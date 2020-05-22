return WebClient.create()
    .get()
    .uri(hostname + ":" + port + "/user" + "/repos" + "?access_token=" + ACCESS_TOKEN + "&type=private")
    .retrieve()
    .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new WebServerException("Problem with service", null)))
    .bodyToFlux(Repository.class)
    .onErrorResume(WebServerException.class, (e) -> Flux.empty())
    .filter(repository -> repository.getName().contains(user.getName()));