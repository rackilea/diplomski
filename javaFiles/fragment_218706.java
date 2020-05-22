@Override
protected void doPostSetup() throws Exception {
    context.getRouteDefinition("MY_ROUTE").adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
            replaceFromWith("direct:teststart");
        }
    });
    // give direct:write2File the id 'splitter' to be able to advice it
    context.getRouteDefinition("splitter").adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
            weaveByType(LogDefinition.class).after().to("mock:end");
        }
    });
    context.start();
}

@Test
public void testUnmarshal() throws Exception {
    mockEndResult.expectedMessageCount(3);
    mockEndResult.expectedBodiesReceived("F1:::L1", "F2:::L2", "F3:::L3");

    template.sendBody("direct:teststart", new File("src/test/resources/test.txt"));

    mockEndResult.assertIsSatisfied();
}