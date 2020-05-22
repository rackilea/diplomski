@Bean
public ConversionService conversionService(Set<Converter<?, ?>> converters) {
    final ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
    factory.setConverters(converters);
    factory.afterPropertiesSet(); // necessary
    return factory.getObject();
}