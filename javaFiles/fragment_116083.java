@Test
    public void fluxTest() {
        Function<Throwable, Publisher<String>> fallback = error -> {
            if (error instanceof IllegalArgumentException) {
                System.out.println(error.getMessage());
                return Flux.empty();
            } else {
                return Flux.error(error);
            }
        };

        Flux<String> sourceFlux = Flux.just("one")
                .concatWith(Flux.<String>error(() -> new IllegalArgumentException("error"))
                        .onErrorResume(fallback))
                .concatWith(Flux.just("three", "four", "five")
                        .onErrorResume(fallback));

        StepVerifier.create(sourceFlux)
                .expectNextCount(4)
                .verifyComplete();
    }