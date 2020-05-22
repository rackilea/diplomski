@Bean
public HttpMessageConverters customConverters() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.featuresToEnable(
      JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);

    final AbstractJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.valueOf("application/vnd.toll-pricing+json")));

    return new HttpMessageConverters(converter);
}