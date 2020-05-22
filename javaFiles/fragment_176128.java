String json = "{\"bar\":\"Value\"}";
ObjectMapper deserializerMapper = new ObjectMapper();
Foo foo = deserializerMapper.readValue(json, Foo.class);
System.out.println("Foo object: " + foo);

ObjectMapper serializerMapper = new ObjectMapper();
serializerMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
serializerMapper.addMixInAnnotations(Foo.class, FooMixIn.class);
System.out.println("JSON: " + serializerMapper.writeValueAsString(foo));