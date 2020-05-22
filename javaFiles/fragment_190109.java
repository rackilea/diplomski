/**
 * Class for storing a {@code Temporal} of varying precision,
 * {@code Year}, {@code YearMonth}, or {@code LocalDate}.
 */
class DynamicTemporal {

    private enum Precision {
        YEAR {
            @Override
            protected int compare(Temporal a, Temporal b) {
                return widen(a).compareTo(widen(b));
            }
            private Year widen(Temporal value) {
                return Year.from(value);
            }
        },
        MONTH {
            @Override
            protected int compare(Temporal a, Temporal b) {
                return widen(a).compareTo(widen(b));
            }
            private YearMonth widen(Temporal value) {
                return YearMonth.from(value);
            }
        },
        DAY {
            @Override
            protected int compare(Temporal a, Temporal b) {
                return widen(a).compareTo(widen(b));
            }
            private LocalDate widen(Temporal value) {
                return (LocalDate) value;
            }
        };
        protected abstract int compare(Temporal a, Temporal b);
    }

    private final Temporal value;
    private final Precision precision;

    public static DynamicTemporal parse(String text) {
        if (text == null || text.equals("NULL"))
            return null;
        if (text.length() >= 10)
            return new DynamicTemporal(LocalDate.parse(text), Precision.DAY);
        if (text.length() >= 7)
            return new DynamicTemporal(YearMonth.parse(text), Precision.MONTH);
        return new DynamicTemporal(Year.parse(text), Precision.YEAR);
    }

    private DynamicTemporal(Temporal value, Precision precision) {
        this.value = value;
        this.precision = precision;
    }

    public int compareTo(DynamicTemporal other) {
        Precision effectivePrecision = (this.precision.compareTo(other.precision) <= 0 ? this.precision : other.precision);
        return effectivePrecision.compare(this.value, other.value);
    }
}