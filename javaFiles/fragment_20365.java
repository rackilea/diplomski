private ExchangeFilterFunction contentTypeInterceptor() {
    return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> 
        Mono.just(ClientRequest.from(clientRequest)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
            .build()));
}