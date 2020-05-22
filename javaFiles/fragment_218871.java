WebClient webClient = //...
webClient.get().uri("/persons/1")
  .retrieve()
  .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.error(new MyCustomException()))
  .bodyToMono(...);