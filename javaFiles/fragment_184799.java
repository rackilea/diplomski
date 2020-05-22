public class DualValue {
    private final String stringValue;
    private final Long   longValue;

    public DualValue(final String stringValue) {
        this.stringValue = stringValue;
        this.longValue = null;
    }

    public DualValue(final Long longValue) {
        this.stringValue = null;
        this.longValue = longValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public boolean isString() {
        return stringValue != null;
    }

    public boolean isLong() {
        return longValue != null;
    }

    // next two are optional but should be implemented,
    // if you ever want to use this class as key of a Map

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DualValue dualValue = (DualValue) o;

        if (longValue != null ? !longValue.equals(dualValue.longValue) : dualValue.longValue != null) {
            return false;
        }
        if (stringValue != null ? !stringValue.equals(dualValue.stringValue) : dualValue.stringValue != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = stringValue != null ? stringValue.hashCode() : 0;
        result = 31 * result + (longValue != null ? longValue.hashCode() : 0);
        return result;
    }
}