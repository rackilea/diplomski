private Map<String, Object> buildDefaults() {
Map<String, Object> properties = new HashMap<>();
List<String> hostPorts = Lists.newArrayList();

for (String url : Splitter.on(",").split(checkNotNull(getenv("KAFKA_URL")))) { 
    try {
    URI uri = new URI(url);
    hostPorts.add(format("%s:%d", uri.getHost(), uri.getPort()));

    switch (uri.getScheme()) {
        case "kafka":
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
        break;
        case "kafka+ssl":
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");

        try {
            EnvKeyStore envTrustStore = EnvKeyStore.createWithRandomPassword("KAFKA_TRUSTED_CERT");
            EnvKeyStore envKeyStore = EnvKeyStore.createWithRandomPassword("KAFKA_CLIENT_CERT_KEY", "KAFKA_CLIENT_CERT");

            File trustStore = envTrustStore.storeTemp();
            File keyStore = envKeyStore.storeTemp();

            properties.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, envTrustStore.type());
            properties.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStore.getAbsolutePath());
            properties.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, envTrustStore.password());
            properties.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, envKeyStore.type());
            properties.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, keyStore.getAbsolutePath());
            properties.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, envKeyStore.password());
            properties.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
        } catch (Exception e) {
            throw new RuntimeException("There was a problem creating the Kafka key stores", e);
        }
        break;
        default:
        throw new IllegalArgumentException(format("unknown scheme; %s", uri.getScheme()));
    }
    } catch (URISyntaxException e) {
    throw new RuntimeException(e);
    }
}

properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, Joiner.on(",").join(hostPorts));
return properties;
}

@Bean
public ProducerFactory<String, String> producerFactory() {
Map<String, Object> config = buildDefaults();

config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

return new DefaultKafkaProducerFactory<>(config);
}

@Bean
public ConsumerFactory<String, String> consumerFactory() {
Map<String, Object> config = buildDefaults();
config.put(ConsumerConfig.GROUP_ID_CONFIG, "xyz");
config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
return new DefaultKafkaConsumerFactory<>(config);
}

@Bean
public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
factory.setConsumerFactory(consumerFactory());
return factory;
}

@Bean
public KafkaTemplate<String, String> kafkaTemplate() {
return new KafkaTemplate<>(producerFactory());
}