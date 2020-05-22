@Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModules(vavr());
    objectMapper.setSerializationInclusion(NON_ABSENT);

    return objectMapper;
  }