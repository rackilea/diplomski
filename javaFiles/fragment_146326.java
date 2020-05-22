Mono<String> firstMono = Mono.just("Some payload");
CompletableFuture<String> alternativePromise = CompletableFuture.supplyAsync(() -> {
        System.out.println("Hi there");
        return "Alternative";
    }); // future computation already tiggered
Mono<String> alternativeMono = Mono.fromFuture(alternativePromise);
Mono<String> result = firstMono.switchIfEmpty(alternativeMono);