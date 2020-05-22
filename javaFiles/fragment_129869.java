webClient.method(HttpMethod.POST)
         .uri(uriBuilder -> uriBuilder.pathSegment("api", "payments").build())
         .body(BodyInserters.fromObject(createPostRequest(paymentConfirmationData)))
         .accept(MediaType.APPLICATION_JSON)
         .retrieve()
         .onStatus(HttpStatus::is4xxServerError, response -> ...)
         .onStatus(HttpStatus::is5xxServerError, response -> ...)
         ...
         .block();