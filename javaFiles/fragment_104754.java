public class JacksonAnyGetter {

    static final String JSON = " { \n" +
            "   \"name\" : \"Snehal\",\n" +
            "   \"property1\" : \"value11\",\n" +
            "   \"property2\" : \"value12\",\n" +
            "   \"property3\" : \"value13\"\n" +
            "\n" +
            " }";

    static class Bean {
        public String name; // we always have name
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
                    "name='" + name + '\'' +
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