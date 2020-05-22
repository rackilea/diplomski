final CamelContext context = new DefaultCamelContext();

context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
context.addRoutes(new RouteBuilder() {
    @Override
    public void configure() {
        from("activemq:queue:q?concurrentConsumers=5")
                .process(exchange -> {
                    System.out.println(Thread.currentThread() + " - " + exchange.getIn().getBody());
                    Thread.sleep(5000);
                });
    }
});
context.start();

for (int i = 0; i < 1000; ++i) {
    context.createFluentProducerTemplate()
            .withBody("This is a message from group : " + (i % 5))
            .withHeader("JMSXGroupID", "" + (i % 5))
            .to("activemq:queue:q")
            .send();
}