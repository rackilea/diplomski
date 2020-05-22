@Bean
public IntegrationFlow mainFlow() {
    // @formatter:off
    return IntegrationFlows
        .from(integerMessageSource(), c -> c.poller(Pollers.fixedRate(1000)))
        .publishSubscribeChannel(pubSub -> pubSub
            .subscribe(flow -> flow
                .bridge(e -> e.id("s1"))
                .handle(message -> LOG.info("Handling message, step 1: {}", message.getPayload())))
            .subscribe(flow -> flow
                .bridge(e -> e.id("s2"))
                .handle(message -> LOG.info("Handling message, step 2: {}", message.getPayload())))
            .subscribe(flow -> flow
                .transform(source -> MessageBuilder.withPayload("Error").build())
                .handle(message -> {
                    LOG.info("Error");
                }))
            .subscribe(flow -> flow
                .bridge(e -> e.id("s4"))
                .handle(message -> LOG.info("Handling message, step 4: {}", message.getPayload())))
        )
        .get();
    // @formatter:on
}