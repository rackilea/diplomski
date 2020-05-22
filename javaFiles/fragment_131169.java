public Mono<ServerResponse> add(ServerRequest request) {
    logger.debug("DemoPOJOHandler.add( ServerRequest )");

    request.bodyToMono(DemoPOJO.class).doOnSuccess(demoPOJO -> System.out.println("DEMO -> " + demoPOJO.toString()));
    return  ServerResponse.ok().build();
}