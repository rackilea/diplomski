public Mono<ServerResponse> getStatus(ServerRequest req) {
    return req.bodyToFlux(Request.class)
            .collectList()
            .doOnNext(requestBody -> System.out.println("Do your service start here in the background."))
            .flatMap(requestBody -> ServerResponse.ok().syncBody("Service started for: " + requestBody));
}