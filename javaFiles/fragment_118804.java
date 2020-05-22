/** Integer formatter that accepts empty values. */
public class LenientIntegerFormatter extends PropertyFormatter {

    public LenientIntegerFormatter(Property propertyDataSource) {
        setPropertyDataSource(propertyDataSource);
    }

    @Override
    public Object parse(String formattedValue) throws Exception {
        if ("".equals(formattedValue))
            return null;
        else
        return Integer.valueOf(formattedValue);
    }

    @Override
    public String format(Object value) {
        if (value == null)
            return "";

        return ((Integer) value).toString();
    }

    @Override
    public Class<?> getType() {
        return String.class;
    }
}