public class JacksonAnyGetter {

    static final String JSON = "{"
            + "  \"id\": 123,"
            + "  \"name\": \"some name\","
            + "  \"custom_name\": \"Some value\","
            + "  \"some_other_custom_name\": \"Some other value\""
            + "}";

    static class Bean {
        public int id;
        public String name;
        private Map<String, Object> properties = new HashMap<>();

        @JsonAnySetter
        public void add(String key, String value) {
            properties.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, Object> getProperties() {
            return properties;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", properties=" + properties +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Bean bean = mapper.readValue(JSON, Bean.class);
        System.out.println(bean);
        final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
        System.out.println(json);
    }
}