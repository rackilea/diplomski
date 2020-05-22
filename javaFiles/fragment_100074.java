ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

String originalJson = ...
JsonNode tree = objectMapper .readTree(originalJson);
String formattedJson = objectMapper.writeValueAsString(tree);