@Bean
 public ConcurrentKafkaListenerContainerFactory<String, Bytes> kafkaListenerContainerFactory() {

 ConcurrentKafkaListenerContainerFactory<String, Bytes> factory =
    new ConcurrentKafkaListenerContainerFactory<>();
 factory.setConsumerFactory(consumerFactory());
 factory.setMessageConverter(new StringJsonMessageConverter());
 return factory;
}