@Configuration
public class RepositoryRestMvcConfig extends RepositoryRestMvcConfiguration {
    ...

    @Bean
    @Override
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = super.objectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        return mapper;
    }

    @Bean
    @Override
    public ObjectMapper halObjectMapper() {
        ObjectMapper mapper = super.halObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        return mapper;
    }

    ...
}