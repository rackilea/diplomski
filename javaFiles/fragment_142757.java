@Bean
public RedisMessageListenerContainer redisMessageListenerContainer() {
    RedisMessageListenerContainer mlc = new RedisMessageListenerContainer();

    mlc.setConnectionFactory(lettuceConnectionFactory());
    mlc.addMessageListener(new MessageListenerAdapter(redisMsgHandler), 
                           new ChannelTopic("pubsub:queue");


    mlc.addMessageListener(new MessageListenerAdapter(redisMsgHandlerAnother), 
                           new ChannelTopic("pubsub:Otherqueue");

    return mlc;
}