// parse InputJson, to Java Objects 
Map<String, Object> rootNode = mapper.readValue(jsonString, Map.class);

// ... implement the logic  ...

// serialize a java Object into Json 
String outputJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(routOutputs);