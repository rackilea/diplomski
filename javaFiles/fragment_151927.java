public class IntegerStringConverter extends StringConverter<Integer> {
    /** {@inheritDoc} */
    @Override public Integer fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        return Integer.valueOf(value);
    }

    /** {@inheritDoc} */
    @Override public String toString(Integer value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return (Integer.toString(((Integer)value).intValue()));
    }
}