SimpleModule module = new SimpleModule();
module.addDeserializer(Rate.class, new RateDeserializer());
SimpleModule module2 = new SimpleModule();
module2.addDeserializer(Maturity.class, new MaturityDeserializer());
ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule()).registerModule(module).registerModule(module2);
mapper.setDateFormat(new StdDateFormat());