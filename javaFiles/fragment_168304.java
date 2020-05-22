final SimpleModule module = new SimpleModule();
    module.addKeyDeserializer(Long.class, new MyCustomKeyDeserializer());
    final ObjectMapper mapper = new ObjectMapper().registerModule(module);
    final TypeReference<Map<Long, String>> typeRef = new TypeReference<Map<Long, String>>() {};
    final Map<Long, String> deserializedMap1 = mapper.readValue(map1, typeRef);
    final Map<Long, String> deserializedMap2 = mapper.readValue(map2, typeRef);