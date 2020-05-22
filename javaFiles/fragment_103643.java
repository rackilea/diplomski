@Bean
protected IntegrationFlow s3ChannelFlow() {
    // @see http://docs.spring.io/spring-integration/reference/html/files.html#file-reading
    // @formatter:off
    return IntegrationFlows
        .from(s3Channel())
        .enrichHeaders(h -> h.headerFunction(RunStats.FILE_TOKEN, f -> UUID.randomUUID().toString()))
        .channel(runStatsChannel())
        .channel(c -> c.executor(Executors.newFixedThreadPool(persistencePoolSize)))
        .transform(new FileToInputStreamTransformer())
        .split(new FileSplitter())
        .transform(new JsonToObjectViaTypeHeaderTransformer(new Jackson2JsonObjectMapper(objectMapper), typeSupport))
        .publishSubscribeChannel(p -> p.subscribe(persistenceSubFlow()))
        .get();
    // @formatter:on
}

@Bean
public MessageChannel runStatsChannel() {
    DirectChannel wiretapChannel = new DirectChannel();
    wiretapChannel.subscribe(new RunStatsHandler(runStatsRepository));
    DirectChannel loggingChannel = new DirectChannel();
    loggingChannel.addInterceptor(new WireTap(wiretapChannel));
    return loggingChannel;
}