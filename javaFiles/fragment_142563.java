class UnmodifiableSetDeserializer extends JsonDeserializer<Set> {

@Override
public Set deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    JsonNode node = mapper.readTree(jp);
    Set<Object> resultSet = new HashSet<Object>();
    if (node != null) {
        if (node instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode) node;
            Iterator<JsonNode> nodeIterator = arrayNode.iterator();
            while (nodeIterator.hasNext()) {
                JsonNode elementNode = nodeIterator.next();
                resultSet.add(mapper.readValue(elementNode.traverse(mapper), Object.class));
            }
        } else {
            resultSet.add(mapper.readValue(node.traverse(mapper), Object.class));
        }
    }
    return Collections.unmodifiableSet(resultSet);
}
}