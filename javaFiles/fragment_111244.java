from("direct:MessageEndpoint1")
  .setHeader(Exchange.HTTP_METHOD, constant("GET"))
  .enrich("http://localhost:9003/MessageEndpoint2", new AggregationStrategy() {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
      // write an aggregation strategy that makes sense here...
    }
  })
  .process(new MessageTransformationProcessor())
  .to("direct:MessageEndpoint3");