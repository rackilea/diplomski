ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
MyObject data = new MyObject();
data.setTimestamp(LocalDateTime.now());
String result = mapper.writeValueAsString(data);
System.out.println(result);
JsonNode tree = mapper.reader().readTree(result);
mapper.treeToValue(tree, MyObject.class);