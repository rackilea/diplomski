public <T> T decode(String json, Class<T> type) throws IOException {
    JsonNode jsonNode = mapper.readTree(json);

    if (jsonNode.isObject() && (jsonNode.get("payload") == null  || jsonNode.get("payload").size() == 0)) {
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.putNull("payload");
    }

    return mapper.treeToValue(jsonNode, type);
}