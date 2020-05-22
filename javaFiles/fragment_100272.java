JSON = // stuff you have in example
ObjectMapper mapper = new ObjectMapper();
JsonNode jsonNode = mapper.readTree(JSON);
// using root node for this example
if (jsonNode.isObject()) {
    ((ObjectNode) jsonNode).put("classname", "com.stackoverflow.Cheese");
}