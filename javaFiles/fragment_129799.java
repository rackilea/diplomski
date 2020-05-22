ClientHttpConnector httpConnector = new HttpHandlerConnector((request, response) -> {
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);

        DataBufferFactory bufferFactory = response.bufferFactory();
        return response.writeWith(Mono.just(bufferFactory.wrap("FOO\nBAR\n".getBytes())))
                .then(Mono.defer(response::setComplete));
    });

    WebClient webClient = WebClient.builder()
            .clientConnector(httpConnector)
            .build();

    new DirectFieldAccessor(this.reactiveOutbound)
            .setPropertyValue("webClient", webClient);