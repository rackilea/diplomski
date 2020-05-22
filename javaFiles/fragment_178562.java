@Bean
@Transformer(inputChannel = "RequestChannel", outputChannel = "enricherOutputChannel")
public HeaderEnricher makeEnricher() {

    Map<String, ? extends HeaderValueMessageProcessor<?>> headersToAdd = Collections
        .singletonMap(HttpHeaders.CONTENT_TYPE, new StaticHeaderValueMessageProcessor<>("application/xml"));

    HeaderEnricher enricher = new HeaderEnricher(headersToAdd);
    enricher.setDefaultOverwrite(true);

    return enricher;
}