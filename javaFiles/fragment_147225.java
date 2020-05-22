@Bean
public ConversionService conversionService(ConversionServiceFactoryBean factory) {
    return factory.getObject();
}

@Bean
public ConversionServiceFactoryBean conversionServiceFactoryBean(Set<Converter<?, ?>> converters) {
    ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
    factory.setConverters(converters);
    return factory;
}