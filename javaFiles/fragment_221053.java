@Bean
public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter(
        Jackson2ObjectMapperBuilder builder) {
    ObjectMapper mapper = builder.createXmlMapper(true).build();
    ((XmlMapper) mapper).enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
    return new MappingJackson2XmlHttpMessageConverter(mapper);
}