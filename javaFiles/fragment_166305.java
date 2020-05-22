public Mono<ServerResponse> addPlanet(ServerRequest serverRequest) {
    Mono<PlanetDTO> planetDTO = serverRequest.bodyToMono(PlanetDTO.class);

    return planetDTO.map(p -> new Planet(p))
            .flatMap(planetService::addPlanet)
            .flatMap(p ->
                created(UriComponentsBuilder.fromPath("planet/" + p.getId()).build().toUri())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromObject(new SWMessageDTO("Planet has been created!", 201)
                    ))
            );