@Bean // referenced in the tests as art
public AsyncRabbitTemplate asyncRabbitTemplate(ConnectionFactory connectionFactory, RabbitTemplate rabbitTemplate) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
    container.setQueueNames(QUEUE_NAME);
    return new AsyncRabbitTemplate(rabbitTemplate, container);
}