public class JacksonLocationInException {
    public static class Bean {
        public final String field;

        @JsonCreator
        public Bean(@JsonProperty("field") final String field) {
            if ("invalid".equals(field)) {
                throw new IllegalArgumentException("Field is invalid");
            }
            this.field = field;
        }
    }

    private static class DelegatingJsonDeserializer extends DelegatingDeserializer {

        public DelegatingJsonDeserializer(final JsonDeserializer<?> delegatee) {
            super(delegatee);
        }

        @Override
        protected JsonDeserializer<?> newDelegatingInstance(
                final JsonDeserializer<?> newDelegatee) {
            return this._delegatee;
        }

        @Override
        public Object deserialize(final JsonParser jp, final DeserializationContext ctxt)
                throws IOException {
            try {
                return super.deserialize(jp, ctxt);
            } catch (final JsonMappingException e) {
                throw new JsonMappingException(e.getMessage(), jp.getCurrentLocation(), e);
            }
        }
    }

    private static class MyBeanDeserializerModifier extends BeanDeserializerModifier {
        @Override
        public JsonDeserializer<?> modifyDeserializer(
                final DeserializationConfig config,
                final BeanDescription beanDesc,
                final JsonDeserializer<?> deserializer) {
            return new DelegatingJsonDeserializer(deserializer);
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new MyBeanDeserializerModifier());
        mapper.registerModule(module);
        final String json = "{          " +
                "\"field\":\"invalid\"}";
        System.out.println(mapper.readValue(json, Bean.class));
    }

}