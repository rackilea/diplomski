ObjectMapper mapper = new ObjectMapper();
mapper.enable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);

Map<String, String[]> props = new HashMap<>();
props.put("fname", new String[] {"mridang"});
props.put("age", new String[] {"1"});
props.put("other", new String[] {"one", "two"});

Person person = mapper.convertValue(props, Person.class);