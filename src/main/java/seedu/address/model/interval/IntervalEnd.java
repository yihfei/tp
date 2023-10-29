package seedu.address.model.interval;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an Interval's End in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEnd(String)}
 */

public class IntervalEnd {

    public static final String MESSAGE_CONSTRAINTS = "That is not a valid time format. End has a format of HHMM";
    public static final String VALIDATION_REGEX = "^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$";
    public final String value;

    /**
     * Constructs a {@code End}.
     *
     * @param end A valid phone number.
     */
    public IntervalEnd(String end) {
        requireNonNull(end);
        checkArgument(isValidEnd(end), MESSAGE_CONSTRAINTS);
        value = end;
    }

    public static boolean isValidEnd(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    private Date parse(String test) throws ParseException {
        assert isValidEnd(test);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");

        return dateFormat.parse(test);
    }

    public Date getTime() throws ParseException {
        return parse(value);
    }

    public int toInt() {
        return Integer.parseInt(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof seedu.address.model.person.End)) {
            return false;
        }

        seedu.address.model.person.End otherEnd = (seedu.address.model.person.End) other;
        return value.equals(otherEnd.value);
    }
}
