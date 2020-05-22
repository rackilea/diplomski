class PrimitiveOrPojoJsonDeserializer extends JsonDeserializer implements ContextualDeserializer {

    private String primitiveName;
    private JavaType type;

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> deserializer = ctxt.findRootValueDeserializer(type);
        if (p.currentToken() == JsonToken.START_OBJECT) {
            return deserializer.deserialize(p, ctxt);
        } else if (p.currentToken() == JsonToken.VALUE_STRING) {
            BeanDeserializer beanDeserializer = (BeanDeserializer) deserializer;
            try {
                Object instance = beanDeserializer.getValueInstantiator().getDefaultCreator().call();
                SettableBeanProperty property = beanDeserializer.findProperty(primitiveName);
                property.deserializeAndSet(p, ctxt, instance);
                return instance;
            } catch (Exception e) {
                throw JsonMappingException.from(p, e.getMessage());
            }
        }

        return null;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
        JsonPrimitiveName annotation = property.getAnnotation(JsonPrimitiveName.class);

        PrimitiveOrPojoJsonDeserializer deserializer = new PrimitiveOrPojoJsonDeserializer();
        deserializer.primitiveName = annotation.value();
        deserializer.type = property.getType();

        return deserializer;
    }
}