@Configuration
class RepositoryRestAdapterConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS );
    }

}