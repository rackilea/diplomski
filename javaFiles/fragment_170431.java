context.getRouteDefinition("myRouteId").adviceWith(context, new AdviceWithRouteBuilder() {
    @Override
    public void configure() throws Exception {
        // mock all endpoints
        mockEndpoints();
    }
});

getMockEndpoint("mock:direct:start").expectedBodiesReceived("Hello World");

template.sendBody("direct:start", "Hello World");