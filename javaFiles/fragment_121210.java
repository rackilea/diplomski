@Bean
public StandardIntegrationFlow integrationFlow() {
    return IntegrationFlows
            .from(sourceDirectory(), configurer -> configurer.poller(Pollers.fixedDelay(10000)))
            .channel("fileInputChannel")

            .filter(onlyCSVs())
            .transform(fileToStringTransformer())
            .transform(GenericMessage.class, message -> message.getPayload().split("[\\r\\n]+"))
            .split()
            .handle(m -> System.out.println((String.valueOf(Math.random()) + m.getPayload())))
            .get();
}