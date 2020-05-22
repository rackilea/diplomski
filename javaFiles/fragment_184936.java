class OpDeserializer extends JsonDeserializer {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final JsonNode node = jsonParser.readValueAsTree();
        final String op = node.get("op").asText();
        switch (op) {
            case "typeA": return mapper.treeToValue(node, TypeA.class);
            case "typeB": return mapper.treeToValue(node, TypeB.class);
            default: return mapper.treeToValue(node, Object.class);
        }
    }
}