public class JacksonTypeInfo {
    public static class Bean {
        public final String key;

        @JsonCreator
        public Bean(@JsonProperty("key") final String key) {this.key = key;}
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .enableDefaultTypingAsProperty(
                        ObjectMapper.DefaultTyping.NON_FINAL,
                        "@class");
        final String json = objectMapper.writeValueAsString(new Bean("value"));
        System.out.println(json);
        System.out.println(objectMapper.readValue(json, Object.class));
    }
}