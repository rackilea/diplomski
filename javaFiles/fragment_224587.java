public static class XyzDeserializer extends JsonDeserializer<Map<Integer, String>> {

    @Override
    public Map<Integer, String> deserialize(JsonParser p,
                                            DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.getCodec().readTree(p);
        Map<Integer, String> map = new HashMap<>();
        rootNode.forEach(n -> map.put(
                n.get("fooId").intValue(),
                n.get("barVal").asText()
        ));
        return map;
    }
}