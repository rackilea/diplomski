@Bean(name = "kafkaListenerContainerFactory")
public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
    ConsumerFactory<Object, Object> kafkaConsumerFactor,
    ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {

  ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
      new ConcurrentKafkaListenerContainerFactory<>();
  configurer.configure(factory, kafkaConsumerFactor);

  ContainerProperties containerProperties = factory.getContainerProperties();
  containerProperties.setMissingTopicsFatal(false);

  ...
  return factory;
}