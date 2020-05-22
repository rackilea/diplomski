JsonNode root = mapper.readTree(SCHEMA);
List<JsonNode> required = root.findParents("required");
for (JsonNode node: required) {
    Object prettyOutput = mapper.readValue(node, Object.class);
    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(prettyOutput));
}