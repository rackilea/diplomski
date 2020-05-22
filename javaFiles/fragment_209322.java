Mono<Model> response = Mono.defer(() -> webClientBuilder
        .build()
        .get()
        .uri(uriBuilder -> uriBuilder
                .path("/getItems")
                .queryParam("limit", 100)
                .queryParam("offset", getOffset())
                .build())
        .retrieve()
        .bodyToMono(Model.class)
);


Flux.from(response
        .doOnEach(System.out::println)
        .flatMap(model -> {
            setOffset(getOffset() + 100);
            log.info("Offset: " + getOffset());
            return repository.saveAll(model.getData().getResults()).collectList();
        }).delayElement(Duration.ofSeconds(15))
).repeat(() -> getOffset() <= 45000).subscribe();