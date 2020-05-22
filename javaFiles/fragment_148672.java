@Bean
public ConsumerFactory<String, String> newStringConsumerFactory() {
  return newConsumerFactory(String.class);
}

private <T> ConsumerFactory <String, T> newConsumerFactory(Class<T> t) {
 return new DefaultKafkaConsumerFactory<>(consumerConfigs(),
  new StringDeserializer(),
  new JsonDeserializer<>(t, objectMapper)
 );
}