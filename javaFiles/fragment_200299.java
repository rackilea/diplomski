private static class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
         from("test-jms:queue:order1")
            .to("test-jms:queue:order2");
    }