@Bean
@RefreshScope
public ConsumerFactory<?, ?> kafkaConsumerFactory() {
    return new DefaultKafkaConsumerFactory<>(this.properties.buildConsumerProperties());
}

@Bean
@RefreshScope
public ProducerFactory<?, ?> kafkaProducerFactory() {
    DefaultKafkaProducerFactory<?, ?> factory = new DefaultKafkaProducerFactory<>(
            this.properties.buildProducerProperties());
    String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
    if (transactionIdPrefix != null) {
        factory.setTransactionIdPrefix(transactionIdPrefix);
    }
    return factory;
}