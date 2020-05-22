@Bean
public ConversionServiceFactoryBean conversionService(Set<Converter<?, ?>> converters) {
    final ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
    factory.setConverters(converters);
    return factory;
}