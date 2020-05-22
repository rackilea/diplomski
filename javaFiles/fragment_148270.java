// extend or add a customized couchbase config like this
public class CustomCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(
            BigDecimalToString.INSTANCE,     
            StringToBigDecimalConverter.INSTANCE));
    }

    @WritingConverter
    public static enum BigDecimalToString implements Converter<BigDecimal, String> {
        INSTANCE;

        @Override
        public String convert(BigDecimal source) {
            // or a more appropriate implementation
            return source.toString() ;
        }

    }


    @ReadingConverter
    public static enum StringToBigDecimalConverter implements Converter<String, BigDecimal> {
        INSTANCE;

        @Override
        public BigDecimal convert(String source) {
            return new BigDecimal(source);
        }

    }

}