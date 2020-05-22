@Bean
ChannelTopic channelTopic() {
    return new ChannelTopic(UUID.randomUUID().toString());
}

@Bean
RedisMessageListenerContainer redisContainer(JedisConnectionFactory jedisConnectionFactory) {
    final RedisMessageListenerContainer redisContainer = new MessageListenerContainerAdapter();
    redisContainer.setConnectionFactory(jedisConnectionFactory);
    redisContainer.addMessageListener(messageListenerAdapter(messageReceiveQueue()), channelTopic());
    return redisContainer;
}