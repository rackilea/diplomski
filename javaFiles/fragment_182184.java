@Bean
public ProducerFactory<String, Object> producerFactoryWithSnakeCaseValueSerializer(KafkaProperties kafkaProperties) {
    Map<String, Object> props = producerConfigsWithSnakeCaseValueSerializer(kafkaProperties.getDefaultSettings());
    JsonSerializer<Object> valueSerializer = new JsonSerializer<>(createObjectMapper(SNAKE_CASE));
    valueSerializer.setAddTypeInfo(false);
    return new DefaultKafkaProducerFactory<>(props, Serdes.String().serializer(), valueSerializer);
}

private static Map<String, Object> producerConfigsWithSnakeCaseValueSerializer(Map<String, String> defaultSettings) {
    Map<String, Object> props = new HashMap<>(defaultSettings);
    ...
    return props;
}

@Bean
public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerConfigsWithSnakeCaseValueSerializer) {
    KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<>(producerConfigsWithSnakeCaseValueSerializer);
    kafkaTemplate.setDefaultTopic("topicName");
    return kafkaTemplate;
}