@Bean
public IntegrationFlow mainFlow() {
    // @formatter:off
    return IntegrationFlows
        .from(integerMessageSource(), c -> c.poller(Pollers.fixedRate(1000)))
        .publishSubscribeChannel(pubSub -> pubSub
            .subscribe(flow -> flow
                .handle(handler("Handling message, step 1: {}")))
            .subscribe(flow -> flow
                .handle(handler("Handling message, step 2: {}")))
            .subscribe(flow -> flow
                .transform(message -> "Error")
                .handle(message -> {
                    LOG.info("Error");
                }))
            .subscribe(flow -> flow
                .handle(handler("Handling message, step 4: {}")))
        )
        .get();
    // @formatter:on
}

private MessageHandler handler(String format) {
    return new AbstractMessageHandler() {

        @Override
        protected void handleMessageInternal(Message<?> message) throws Exception {
            LOG.info(format, message.getPayload());
        }

    };

}