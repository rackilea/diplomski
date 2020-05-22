//instantiate an objectMapper and alter the deserialization functionality
ObjectMapper mapper = new ObjectMapper();
SimpleModule simpleModule = new SimpleModule();
simpleModule.setDeserializerModifier(new BeanDeserializerModifier() {
    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        return new DisallowNullDeserializer(beanDesc.getBeanClass(), deserializer);
    }
});
mapper.registerModule(simpleModule);