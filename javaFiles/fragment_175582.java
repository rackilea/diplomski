@Test
public void test() {
  StepVerifier.withVirtualTime(() -> 
        Flux.just(1, 2, 3, 4).delayElements(Duration.ofSeconds(1)))
        .expectSubscription() //t == 0
//move the clock forward by 1s, and check nothing is emitted in the meantime
        .expectNoEvent(Duration.ofSeconds(1))
//so this effectively verifies the first value is delayed by 1s:
        .expectNext(1)
//and so on...
        .expectNoEvent(Duration.ofSeconds(1))
        .expectNext(2)
//or move the clock forward by 2s, allowing events to take place,
//and check last 2 values where delayed
        .thenAwait(Duration.ofSeconds(2))
        .expectNext(3, 4)
        .expectComplete()
//trigger the verification and check that in realtime it ran in under 200ms
        .verify(Duration.ofMilliseconds(200));
}