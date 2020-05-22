ObjectMapper mapper = new ObjectMapper();
mapper.enable(MapperFeature.USE_ANNOTATIONS);

// create JsonProvider to provide custom ObjectMapper
JacksonJsonProvider provider = new JacksonJsonProvider();
provider.setMapper(mapper);