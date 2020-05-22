Flux<Integer> sums = Flux.range(1, 8)                    // Flux<Integer>
        .window(3, 1)                                    // Flux<Flux<Integer>>
        .flatMap(window -> window.reduce(Integer::sum)); // Flux<Integer>

StepVerifier.create(sums)
        .expectNext(6)  // 1+2+3
        .expectNext(9)  // 2+3+4
        .expectNext(12) // 3+4+5
        .expectNext(15) // 4+5+6
        .expectNext(18) // 5+6+7
        .expectNext(21) // 6+7+8
        .expectNext(15) // 7+8
        .expectNext(8)  // 8
        .verifyComplete();