final ObjectMapper mapper = new ObjectMapper();
    final TypeReference<Map<Long, String>> typeRef = new TypeReference<Map<Long, String>>() {};
    final Map<Long, String> deserializedMap1 = mapper.readValue(map1, typeRef);
    final Map<Long, String> deserializedMap2 = mapper.readValue(map2, typeRef);

    printMap(deserializedMap1);
    printMap(deserializedMap2);