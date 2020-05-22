public class StringToEnumFactory implements ConverterFactory<String, Enum> {

    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnum(targetType);
    }

    private final class StringToEnum<T extends Enum> implements Converter<String, T> {

        private Class<T> enumType;

        public StringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        public T convert(String source) {
            Integer index = Integer.valueOf(source);
            return enumType.getEnumConstants()[index];
        }
    }
}