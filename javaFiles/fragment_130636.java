@Bean
public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(GROUP_ID_CONFIG, "app.topic");
    props.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
    props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    return props;
}

@Bean
public ConsumerFactory<String, TopicPayload> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
            new JsonDeserializer<>(TopicPayload.class));
}

@Bean
public ConcurrentKafkaListenerContainerFactory<String, TopicPayload> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, TopicPayload> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
}