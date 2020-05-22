@Autowired
  void configureObjectMapper(final ObjectMapper mapper) {
   mapper.registerModule(new ParameterNamesModule())
  .registerModule(new Jdk8Module())
  .registerModule(new JavaTimeModule());
  }