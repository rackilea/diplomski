@Bean
public AmqpInboundGateway amqpInbound() {
    AmqpInboundGateway gateway = new AmqpInboundGateway(new SimpleMessageListenerContainer(this.rabbitConnectionFactory));
    gateway.setRequestChannel(inboundChanne());
    return gateway;
}

@Bean
@ServiceActivator(inputChannel = "amqpOutboundChannel")
public AmqpOutboundEndpoint amqpOutbound() {
    AmqpOutboundEndpoint handler = new AmqpOutboundEndpoint(this.rabbitTemplate);
    handler.setOutputChannel(amqpReplyChannel());
    return handler;
}