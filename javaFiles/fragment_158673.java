@Bean
    public IntegrationFlow fileReadingFlow(@Value("${fpml.messages.input}") File directory) {
        return IntegrationFlows
                .from(s -> s.file(directory).patternFilter("*.xml"),
                        e -> e.poller(Pollers.fixedDelay(20000)))
        .....................
                .get();
    }