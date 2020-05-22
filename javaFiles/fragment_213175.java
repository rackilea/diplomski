@Test
public void testTimeToDoOnSubscribeExecution() {
    final long startTime = System.currentTimeMillis();
    System.out.println("Starting at: " + startTime);
    Subscription subscription = Observable.empty()
            .doOnSubscribe(() -> System.out.println("Time to invoke onSubscribe: " + (System.currentTimeMillis() - startTime)))
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribe();
    new TestSubscriber((rx.Observer) subscription).awaitTerminalEvent(2, TimeUnit.SECONDS);
}