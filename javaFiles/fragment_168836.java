onException(SalesforceException.class)
        .onWhen(new Predicate() {

            @Override
            public boolean matches(Exchange exchange) {
                SalesforceException cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, SalesforceException.class);
                return cause.getStatusCode() < 500;
            }
        })
        .log("Handled here if statusCode < 500")
        .useOriginalMessage()
        .handled(true)
        .maximumRedeliveries(3)
        .redeliveryDelay(5000)
        .logRetryAttempted(true);

    onException(SalesforceException.class)
        .onWhen(new Predicate() {

            @Override
            public boolean matches(Exchange exchange) {
                SalesforceException cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, SalesforceException.class);
                return cause.getStatusCode() >= 500;
            }
        })
        .log("Handled here if statusCode >= 500")
        .transform(ExpressionBuilder.simpleExpression("{\"request\" : ${exchangeProperty.requestBody}, \"response\" : ${exchangeProperty.response}}"))
        .to("log:{{logger}}?level=INFO&showHeaders=true")
        .to("amqp:qFailure?exchangePattern=InOnly");