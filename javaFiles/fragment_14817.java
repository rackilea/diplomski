// ...
  .aggregate(new AggregationStrategyImplementation())
    .header("msgId")
    .completionTimeout(2000L)
    .to("direct:persist");
// new transacted route
from("direct:persist")
  .routeId("persist")
  .transacted()
  .multicast()
    .to("direct:saveDocumentMetaData", "direct:importBalanceSheet");