Mono<String> asyncAlternative() {
    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
        System.out.println("Hi there");
        return "Alternative";
    }));
}