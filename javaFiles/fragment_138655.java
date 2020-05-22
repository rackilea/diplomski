public class MulticastRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        AggregationStrategy myAggregationStrategy = new MyAggregationStrategy();
        List<String> listA = Lists.newArrayList("A");
        List<String> listB = Lists.newArrayList("B");
        from("direct:multicast").routeId("multicastRoute").multicast(myAggregationStrategy).to("direct:A", "direct:B").end();

        from("direct:A").setBody(constant(listA));
        from("direct:B").setBody(constant(listB));
    }

    class MyAggregationStrategy implements AggregationStrategy {
        @Override
        public org.apache.camel.Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            System.out.println("Aggregate called with oldExchange = " + (oldExchange == null ? "null" :
                    oldExchange.getIn().getBody().toString()) + ", newExchange = " +
                    newExchange.getIn().getBody().toString());
            return newExchange;
        }
    }
}