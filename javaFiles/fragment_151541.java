public class MyDslValueConverters extends DefaultTerminalConverters {

    IValueConverter<Long> longValueConverter = new IValueConverter<Long>() {

        @Override
        public Long toValue(String string, INode node) throws ValueConverterException {
            // TODO make this more robust
            return Long.parseLong(string.substring(0, string.length()-1));
        }

        @Override
        public String toString(Long value) throws ValueConverterException {
            // TODO make this more robust
            return Long.toString(value)+"L";
        }

    };

    @ValueConverter(rule = "LONG")
    public IValueConverter<Long> LONG() {
        return longValueConverter;
    }

}