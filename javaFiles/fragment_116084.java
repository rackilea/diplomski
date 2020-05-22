@Test
    public void fluxTest() {
        Function<Throwable, Publisher<String>> fallback = error -> {
            System.out.println(error.getMessage());
            return Flux.empty();
        };

        Flux<String> sourceFlux = Flux.just("one")
                .concatWith(Flux.<String>error(() -> new IllegalArgumentException("error"))
                        .onErrorResume(IllegalArgumentException.class, fallback))
                .concatWith(Flux.just("three", "four", "five")
                        .onErrorResume(IllegalArgumentException.class, fallback));

        StepVerifier.create(sourceFlux)
                .expectNextCount(4)
                .verifyComplete();
    }