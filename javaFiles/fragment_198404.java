ObjectMapper mapper = new ObjectMapper();

//prevent any type as boolean
mapper.disable(MapperFeature.ALLOW_COERCION_OF_SCALARS);

// prevent null as false 
// mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);

System.out.println(mapper.readValue("{\"test\": true}", Foo.class));
System.out.println(mapper.readValue( "{\"test\": 1}", Foo.class));