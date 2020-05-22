public class JacksonMap {

    public static class Bean {
        private final String field;
        private final Map<String, Object> map;

        public Bean(String field, Map<String, Object> map) {
            this.field = field;
            this.map = map;
        }

        public String getField() {
            return field;
        }

        @JsonAnyGetter
        public Map<String, Object> getMap() {
            return map;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Bean map = new Bean("value1", Collections.<String, Object>singletonMap("key1", "value2"));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
    }
}