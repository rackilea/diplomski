public class JacksonSerializerModifier {
    public static interface A {

    }
    public static class B implements A {
        public String field1 = "value1";

        @Override
        public String toString() {
            return field1;
        }
    }
    public static class C implements A {
        public String field2 = "value2";

        @Override
        public String toString() {
            return field2;
        }
    }
    public static class D  {
        public String field3 = "value3";
    }

    private static class MyTypeSerializer extends JsonSerializer<Object> {
        private final JsonSerializer<Object> delegate;

        @SuppressWarnings("unchecked")
        public MyTypeSerializer(JsonSerializer<?> delegate) {
            this.delegate = (JsonSerializer<Object>) delegate;
        }

        @Override
        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {
            if (value instanceof A) {
                jgen.writeString(value.toString());
            } else {
                delegate.serialize(value, jgen, provider);
            }
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(SerializationConfig config,
                                                      BeanDescription beanDesc,
                                                      JsonSerializer<?> serializer) {

                return new MyTypeSerializer(serializer);
            }
        });
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        System.out.println(mapper.writeValueAsString(Arrays.asList(new B(), new C(), new D())));
    }

}