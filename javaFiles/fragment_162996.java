Flux<Foo> addDataConnection() {
    return Flux.create(emitter -> {
        fluxSinks.add(emitter);
    });
}

Flux<Optional<Foo>> initiateFluxStreams() {
    return Flux.merge(addDataConnection().map(f -> Optional.of(f)), addHeartbeat().map(h -> Optional.empty()));
}

Flux<Long> addHeartbeat() {
    return Flux.interval(Duration.ofSeconds(2));
}