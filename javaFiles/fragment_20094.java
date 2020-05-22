ObjectMapper mapper = new ObjectMapper();

TypeReference<LinkedHashMap<String, Object>> typeReference 
    = new TypeReference<LinkedHashMap<String, Object>>() {};
Map<String, Object> root = mapper.readValue(json, typeReference);

root.keySet().forEach(System.out::println);