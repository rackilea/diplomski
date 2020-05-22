Mono<String> firstMono = Mono.just("Some payload");
Mono<String> alternativeMono = Mono.defer(() -> Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
        System.out.println("Hi there");
        return "Alternative";
    }))); // future computation defered
Mono<String> result = firstMono.switchIfEmpty(alternativeMono);