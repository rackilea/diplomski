errorHandler(
        deadLetterChannel("direct:deadLetter")
            .maximumRedeliveries(3)
            .retryAttemptedLogLevel(LoggingLevel.WARN)
            );


from("direct:deadLetter").id("deadLetter")
    .routeId("deadLetter")
    .errorHandler(defaultErrorHandler().disableRedelivery())
    .process(new Processor() {
        public void process(Exchange msg) {
            String MsgHist = org.apache.camel.util.MessageHelper.dumpMessageHistoryStacktrace(msg, new DefaultExchangeFormatter(), false);
            LOG.error(MsgHist, msg);
            msg.getOut().setBody(msg.getIn().getBody(Document.class));
            msg.getOut().setHeaders(msg.getIn().getHeaders());
            msg.getOut().setHeader("MessageHistory",MsgHist);
        }
    })
    .log(LoggingLevel.ERROR,"${exception.stacktrace}")
    .setHeader("ErrorMessage",simple("${exception}",String.class))
    .setHeader("ErrorStacktrace",simple("${exception.stacktrace}",String.class))
            .to("activemqWithoutTransactions:errors");