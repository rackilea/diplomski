ObjectMapper mapper = new ObjectMapper();

SimpleModule module = new SimpleModule();
module.addSerializer(Sample.class, new SampleSerializer());
mapper.registerModule(module);

mapper.writeValueAsString(new Sample("one", "two", "three"));