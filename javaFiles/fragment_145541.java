@PostMapping("/create")
public Mono<Resource> create(@Valid @RequestBody Resource r) {
    run(r).subscribe();
    return repository.save(r);
}

Mono<Void> run(Resource r) {
    WebClient webClient = WebClient.create("http://localhost:8080");
    return webClient.get()
            .retrieve()
            .bodyToMono(String.class)
            .then();
}