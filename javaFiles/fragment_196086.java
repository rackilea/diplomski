class ValidatingSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config,
             BeanDescription beanDesc, JsonSerializer<?> serializer) {
        return new ValidatingSerializer((JsonSerializer<Object>) serializer);
    }
}