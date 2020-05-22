@Bean
public Jackson2ObjectMapperBuilder configureObjectMapper() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    SimpleModule zonedDateTimeSerializer = new SimpleModule();
    zonedDateTimeSerializer.addSerializer(ZonedDateTime.class,new ZonedDateTimeSerialzier());

    builder.modules(zonedDateTimeSerializer);
    return builder;
}