@Bean
public ConsumerFactory<String,PageViewEvent > priceEventConsumerFactory() {

Map<String, Object> props = new HashMap<>();
props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(PageViewEvent.class,false));

}