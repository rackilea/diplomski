import java.time.DateTimeException;    
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.ChronoUnit.*;

public class SimpleDuration implements TemporalAmount {

    private static final List<TemporalUnit> SUPPORTED_UNITS =
        Collections.unmodifiableList(Arrays.asList(YEARS, MONTHS, DAYS, HOURS, MINUTES));

    private final int amount;
    private final ChronoUnit unit;

    private SimpleDuration(int amount, ChronoUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public static SimpleDuration of(int amount, ChronoUnit unit) {
        if (SUPPORTED_UNITS.contains(unit)) {
            return new SimpleDuration(amount, unit);
        } else {
            throw new IllegalArgumentException("Not supported: " + unit);
        }
    }

    @Override
    public long get(TemporalUnit unit) {
        if (this.unit.equals(unit)) {
          return this.amount;
        }
        return 0;
    }

    @Override
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    @Override
    public Temporal addTo(Temporal temporal) {
        return temporal.plus(this.amount, this.unit);
    }

    @Override
    public Temporal subtractFrom(Temporal temporal) {
        return temporal.minus(this.amount, this.unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleDuration) {
            SimpleDuration that = (SimpleDuration) obj;
            return this.unit == that.unit && this.amount == that.amount;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.unit.hashCode() + 37 * Integer.hashCode(this.amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.amount < 0) {
            sb.append('-');
        }
        sb.append('P');
        if (this.unit.isTimeBased()) {
            sb.append('T');
        }
        sb.append(Math.abs(this.amount));
        switch (this.unit) {

            case YEARS :
                sb.append('Y');
                break;

            case MONTHS :
                sb.append('M');
                break;

            case DAYS :
                sb.append('D');
                break;

            case HOURS :
                sb.append('H');
                break;

            case MINUTES :
                sb.append('M');
                break;

            default :
                throw new UnsupportedOperationException(this.unit.name());
        }
        return sb.toString();
    }

    public static SimpleDuration parse(String input) {
        int len = input.length();
        int index = 0;
        boolean negative = false;
        if (len > 0 && input.charAt(0) == '-') {
            negative = true; // for XML-Schema (not for ISO-8601)
            index++;
        }
        if (len >= 3 && input.charAt(index) == 'P') {
            boolean timeBased = (input.charAt(index + 1) == 'T');
            char last = input.charAt(len - 1);
            ChronoUnit unit;
            switch (last) {

                case 'Y' :
                    unit = YEARS;
                    break;

                case 'M' :
                    unit = (timeBased ? MINUTES : MONTHS);
                    break;

                case 'D' :
                    unit = DAYS;
                    break;

                case 'H' :
                    unit = HOURS;
                    break;

                default :
                    throw new DateTimeException(
                        "Unknown unit symbol found at last position: " + input
                    );
            }
            if (unit.isTimeBased() != timeBased) {
                throw new DateTimeException("Invalid XML-Schema-format: " + input);
            }
            try {
              int amount =
                Integer.parseInt(
                  input.substring(index).substring(timeBased ? 2 : 1, len - 1 - index));
              if (amount < 0) {
                throw new DateTimeException(
                  "XML-Schema does not allow negative amounts inside: " + input);
              }
              return SimpleDuration.of(negative ? -amount : amount, unit);
            } catch (NumberFormatException ex) {
                throw new DateTimeException("Invalid XML-Schema-format: " + input, ex);
            }
        }
        throw new DateTimeException("Cannot parse: " + input);
    }

    public static void main(String... args) {
        System.out.println(parse("-PT10M")); // -PT10M
    }
}