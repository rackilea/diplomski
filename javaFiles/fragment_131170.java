public Mono<ServerResponse> add(ServerRequest request) {
    logger.debug("DemoPOJOHandler.add( ServerRequest )");

    return request.bodyToMono(DemoPOJO.class).doOnSuccess(demoPOJO -> service.add(demoPOJO))
                                             .then(ServerResponse.ok().build())
                                             .switchIfEmpty(ServerResponse.badRequest()
                                                                          .contentType(MediaType.APPLICATION_JSON)
                                                                          .build());
}