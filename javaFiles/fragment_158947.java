@Bean
public IntegrationFlow httpInternalServiceFlow() {
    return IntegrationFlows
            .from(Http.inboundGateway("/service/internal")
                    .requestMapping(r -> r.params("name"))
                    .payloadExpression("#requestParams.name"))
            .channel(transformSecuredChannel())
            .<List<String>, String>transform(p -> p.get(0).toUpperCase())
            .get();
}