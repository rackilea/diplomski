@Bean
public IntegrationFlow amqpFlow() {
     return IntegrationFlows.from(Amqp.inboundGateway(this.rabbitConnectionFactory, queue()))
           .transform("hello "::concat)
           .transform(String.class, String::toUpperCase)
           .get();
}

@Bean
public IntegrationFlow amqpOutboundFlow() {
       return IntegrationFlows.from(Amqp.channel("amqpOutboundInput", this.rabbitConnectionFactory))
               .handle(Amqp.outboundAdapter(this.amqpTemplate).routingKeyExpression("headers.routingKey"))
               .get();
}