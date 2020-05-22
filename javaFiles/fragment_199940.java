@Configuration
class ApplicationConfig {

  @Bean
  public JacksonRepositoryPopulatorFactoryBean repositoryPopulator() {

    Resource sourceData = new ClassPathResource("test-data.json");

    JacksonRepositoryPopulatorFactoryBean factory = new JacksonRepositoryPopulatorFactoryBean();
    // Set a custom ObjectMapper if Jackson customization is needed
    factory.setObjectMapper(…);
    factory.setResources(new Resource[] { sourceData });
    return factory;
  }
}