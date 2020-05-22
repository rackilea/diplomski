ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

JacksonJaxbJsonProvider jacksonProvider = new JacksonJaxbJsonProvider();
jacksonProvider.setMapper(mapper);
config.getSingletons().add(jacksonProvider);