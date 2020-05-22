from("direct:input").routeId("enrichHeader")
    .doTry()
        .setHeader("myHeader").constant("someValue)
        .to("direct:output")
    .doCatch(MyException.class)
        .process(new MYExceptionLoggerAndHandler())
   .end();