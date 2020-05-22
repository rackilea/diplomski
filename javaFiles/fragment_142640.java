@Bean
public HttpMessageConverters httpMessageConverters(
        final Jackson2ObjectMapperBuilder builder,
        List<HttpMessageConverter<?>> converters) {
    return new HttpMessageConverters(converters) {

        @Override
        protected List<HttpMessageConverter<?>> postProcessConverters(
                List<HttpMessageConverter<?>> converters) {
            for (HttpMessageConverter<?> converter : converters) {
                if (converter instanceof MappingJackson2HttpMessageConverter) {
                    builder.configure(((MappingJackson2HttpMessageConverter) converter)
                            .getObjectMapper());
                }
            }
            return converters;
        }
    };
}