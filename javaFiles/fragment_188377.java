from("direct:start")
    .log("after direct:start body=${body}")
    .multicast(new MyAggregationStrategy()).parallelProcessing()
      .to("direct:A")
      .to("direct:B")
    .end()
    .to("direct:C");

    from("direct:A").log("A: ${body}").transform(constant("Body changed by A "));
    from("direct:B").log("B: ${body}").transform(constant("Body changed by B "));
    from("direct:C").log("C: ${body}").transform(constant("C - Post-aggregation "));