public JsonFileReader(String filename) throws IOException {
    InputStream stream = null;
    try {
        stream = getClass().getResourceAsStream(filename);
        ObjectMapper mapper = new ObjectMapper();
        final JsonNode result = mapper.readTree(stream);

        for (JsonNode defaultValue : result.path("default-values")) {
            defaultValues.put(
                    defaultValue.get("name").asText(),
                    defaultValue.get("value").asInt());
        }
    } finally {
        if (stream != null) {
            stream.close();
        }
    }
}