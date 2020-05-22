private static class JpaAggregationRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("jpa:com.pns.ab.model.LoanRequest?consumeDelete=false"
             + "&consumer.delay=20000"
             + "&consumer.namedQuery=selectLoanRequests"
             + "&persistenceUnit=LoanServicePU")
                .aggregate(constant(true), new ArrayListAggregationStrategy())
                .completionFromBatchConsumer()
                .process(new JpaProcessor());
    }
}

// Simply combines Exchange body values into an ArrayList<Object>
// Taken from http://camel.apache.org/aggregator2
private static class ArrayListAggregationStrategy implements AggregationStrategy {

    @SuppressWarnings("unchecked")
    @Override
    public Exchange aggregate(final Exchange oldExchange, final Exchange newExchange) {
        final Object newBody = newExchange.getIn().getBody();
        ArrayList<Object> list = null;
        if (oldExchange == null) {
            list = new ArrayList<Object>();
            if (newBody != null) {
                list.add(newBody);
            }
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            list = oldExchange.getIn().getBody(ArrayList.class);
            if (newBody != null) {
                list.add(newBody);
            }
            return oldExchange;
        }
    }

}