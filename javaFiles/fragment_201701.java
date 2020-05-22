private DefaultJackson2JavaTypeMapper classMapper() {
    DefaultJackson2JavaTypeMapper classMapper = new DefaultJackson2JavaTypeMapper();
    Map<String, Class<?>> idClassMapping = new HashMap<>();
    idClassMapping.put(OrderProducer.class.getSimpleName(), OrderProducer.class);
    idClassMapping.put(OrderConsumer.class.getSimpleName(), OrderConsumer.class);
    classMapper.setIdClassMapping(idClassMapping);
    return classMapper;
}