public class JacksonSerializeModifier {
    public static class Bean {
        public final String value;

        public Bean(final String value) {
            this.value = value;
        }

        public void foo() {
            System.out.println("foo() invoked");
        }
    }

    private static class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(
                final SerializationConfig serializationConfig,
                final BeanDescription beanDescription,
                final JsonSerializer<?> jsonSerializer) {
            return new ModifyingSerializer((JsonSerializer<Object>) jsonSerializer);
        }
    }

    private static class ModifyingSerializer extends JsonSerializer<Object> {
        private final JsonSerializer<Object> serializer;

        public ModifyingSerializer(final JsonSerializer<Object> jsonSerializer) {
            this.serializer  = jsonSerializer;
        }

        @Override
        public void serialize(
                final Object o,
                final JsonGenerator jsonGenerator,
                final SerializerProvider serializerProvider)
        throws IOException {
            if (o instanceof Bean) {
                ((Bean) o).foo();
            }
            serializer.serialize(o, jsonGenerator, serializerProvider);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new MyBeanSerializerModifier());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        System.out.println(mapper.writeValueAsString(new Bean("abc")));
    }
}