public class JsonFileReader {
    private Map<String, Integer> defaultValues = new HashMap<>();

    public static void main(String... args) throws IOException {
        final JsonFileReader reader = new JsonFileReader("/foo.json");
        System.out.println(reader.getValue("cobblestone")); // -> 1
    }

    public JsonFileReader(String filename) throws IOException {
        try (InputStream stream = getClass().getResourceAsStream(filename)) {
            ObjectMapper mapper = new ObjectMapper();
            final JsonNode result = mapper.readTree(stream);

            for (JsonNode defaultValue : result.path("default-values")) {
                defaultValues.put(
                    defaultValue.get("name").asText(), 
                    defaultValue.get("value").asInt());
            }
        }
    }

    public Integer getValue(String name) {
        return defaultValues.get(name);
    }
}