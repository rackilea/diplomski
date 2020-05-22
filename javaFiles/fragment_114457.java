@Publisher(channel = "amqpOutboundChannel")
public String send() {
    return myString;
}

@Bean
@ServiceActivator(inputChannel = "amqpOutboundChannel")
public AmqpOutboundEndpoint amqpOutbound(AmqpTemplate amqpTemplate) {
    AmqpOutboundEndpoint outbound = new AmqpOutboundEndpoint(amqpTemplate);
    outbound.setRoutingKey("my.queue.name"); // default exchange - route to queue 'my.queue.name'
    return outbound;
}