public class MyConversionServiceFactoryBean extends ConversionServiceFactoryBean {

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        ConversionService conversionService = getObject();
        ConverterRegistry registry = (ConverterRegistry) conversionService;
        // register converters that need a nested conversion service
        registry.addConverter(new MyCustomConverter(conversionService));
    }
}