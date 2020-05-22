public static void main(String args[]) throws Exception {
    // create CamelContext
    CamelContext context = new DefaultCamelContext();

    // connect to embedded ActiveMQ JMS broker
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
    context.addComponent("jms",
            JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

    // add our route to the CamelContext
    context.addRoutes(new RouteBuilder() {
        @Override
        public void configure() {
            from("jms:queue:QueueA")
            .process(new Processor() {
                public void process(Exchange exchange) throws Exception {
                    String s = exchange.getIn().getBody(String.class);
                    System.out.println("The body of the message is: " + s); 
                }
            }).to("jms:queue:QueueB");
        }
    });

    // start the route and let it do its work
    context.start();
    Thread.sleep(10000);

    // stop the CamelContext
    context.stop();
}