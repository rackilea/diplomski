@Bean
public KafkaAdmin admin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
            StringUtils.arrayToCommaDelimitedString(kafkaEmbedded().getBrokerAddresses()));
    return new KafkaAdmin(configs);
}

@Bean
public NewTopic topic1() {
    return new NewTopic("foo", 10, (short) 2);
}