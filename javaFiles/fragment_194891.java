ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
TypeReference<Map<String, Object>> type = new TypeReference<>() {};
Map<String, Object> biggerMap = mapper.readValue(biggerJson, type);
Map<String, Object> smallerMap = mapper.readValue(smallerJson, type);

biggerMap.put("additional_info", smallerMap);

String outJson = mapper.writeValueAsString(biggerMap);
System.out.println(outJson);