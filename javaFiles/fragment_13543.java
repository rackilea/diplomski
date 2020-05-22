public class JacksonTest {

    public static class Bean {
        private String name;
        public String getName() { return this.name; }
        public void setName(String name) { this.name = name; }

        private Map<String, Object> unrecognizedFields = new HashMap<>();

        @JsonAnyGetter
        public Map<String, Object> getUnrecognizedFields() {
            return this.unrecognizedFields;
        }

        @JsonAnySetter
        public void setUnrecognizedFields(String key, Object value) {
            this.unrecognizedFields.put(key, value);
        }
    }

    private final String json
            = "{\"name\":\"paul\",\"age\":600,\"nickname\":\"peeskillet\"}";
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testDeserialization() throws Exception {
        final Bean bean = mapper.readValue(json, Bean.class);
        final Map<String, Object> unrecognizedFields = bean.getUnrecognizedFields();

        assertEquals("paul", bean.getName());
        assertEquals(600, unrecognizedFields.get("age"));
        assertEquals("peeskillet", unrecognizedFields.get("nickname"));
    }
}