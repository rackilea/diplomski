DeadLetterChannelBuilder errorHandlerBuilder = deadLetterChannel("jms:dummy");
    errorHandlerBuilder.onPrepareFailure(exchange -> {
        exchange.getIn().setHeader("CamelJmsDestinationName",exchange.getIn().getHeader("JMSDestination",String.class).concat(".DLQ"));
    });

    from("jms:input1")
            .to("seda:process");

    from("jms:input2")
            .to("seda:process");

    from("jms:input3")
            .to("seda:process");

    from("seda:process").errorHandler(errorHandlerBuilder)
            .process(exchange -> {
                throw new RuntimeException();
            });