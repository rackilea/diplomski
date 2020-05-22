@Test
public void test() throws Exception {
    SimpleMessageListenerContainer container = (SimpleMessageListenerContainer) this.registry
            .getListenerContainer("myListener");
    ChannelAwareMessageListener listener = (ChannelAwareMessageListener) container.getMessageListener();
    Message message = MessageBuilder.withBody("{\"bar\":\"baz\"}".getBytes())
            .andProperties(MessagePropertiesBuilder.newInstance()
                    .setContentType("application/json")
                    .build())
            .build();
    listener.onMessage(message, mock(Channel.class));
    verify(this.rabbitTemplate).convertAndSend("someExchange", "someRoutingKey", new Foo("BAZ"));
}