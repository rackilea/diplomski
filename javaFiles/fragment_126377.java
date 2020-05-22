private static final ObjectMapper SORTED_MAPPER = new ObjectMapper();
static {
    SORTED_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
}

private String convertNode(final JsonNode node) throws JsonProcessingException {
    final Object obj = SORTED_MAPPER.treeToValue(node, Object.class);
    final String json = SORTED_MAPPER.writeValueAsString(obj);
    return json;
}