static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues
          .of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl())
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }