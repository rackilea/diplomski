private List<String> getJson() {
    List<String> texts = new ArrayList<String>();
    ObjectMapper mapper = new ObjectMapper();
    final JsonNode nodes = objectMapper.readTree(new File("/tmp/notes.json")).get("list");
    if (nodes.isArray()) {
        for (final JsonNode node : nodes) {
            texts.add(node.get("property").asText());
        }
    }
    return texts;
}