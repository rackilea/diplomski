@Bean
public IntegrationFlow testFile() {


    IntegrationFlowBuilder testChannel = IntegrationFlows.from(Files.inboundAdapter(new File("d:/input-files/")),
            e -> e.poller(Pollers.fixedDelay(5000L).maxMessagesPerPoll(10)
            ))
            .enrichHeaders(h -> h.header(MessageHeaders.ERROR_CHANNEL, "testChannel"))
            .channel(MessageChannels.executor(Executors.newFixedThreadPool(5)))

            .transform(o -> {

                throw new RuntimeException("Failing on purpose");

            }).handle(o -> {
            });

    return testChannel.get();


}