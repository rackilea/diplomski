@Bean("Your_id")
public ObjectMapper yamlObjectMapper() {
    return new ObjectMapper(new YAMLFactory());
}

@Bean
@Primary
public ObjectMapper objectMapper() {
    return new ObjectMapper();
}