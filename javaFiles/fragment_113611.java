@Bean
public SimpleMessageListenerContainer replyListenerContainer() {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(pushConnectionFactory());
    container.setQueues(pushQueue());
    container.setMessageListener(pushListener());

    Advice[] adviceChain = new Advice[] { retryAdvice() };
    container.setAdviceChain(adviceChain);

    return container;
}