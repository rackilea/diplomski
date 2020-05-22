@Bean
public ConversionServiceFactoryBean conversionService(Set<Converter<?, ?>> converters) {
    ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
    factory.setConverters(converters);
    return factory;
}