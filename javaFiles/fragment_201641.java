@Test
public void elapsedWithVirtualTimeWorkaround() {
    //we have to create a reference that will be used in 2 places
    VirtualTimeScheduler vts = VirtualTimeScheduler.create();

    StepVerifier.withVirtualTime(() -> Mono.just(1)
                                           .delaySubscription(Duration.ofSeconds(1))
                                           .elapsed(vts), //this avoids the cache problem
            () -> vts, //the supplied scheduler here will be automatically activated by StepVerifier
            1)
                .thenAwait(Duration.ofSeconds(1)) //this uses the same vts once again
                .expectNextMatches(tuple2 -> tuple2.getT1() >= 1000 && tuple2.getT2() == 1)
                .verifyComplete();
}