@Test
public void delayCreation() {
    long start = System.currentTimeMillis();
    Subscription subscription = Observable.just("hello reactive world")
            .delay(200, TimeUnit.MICROSECONDS)
            .subscribe(n -> System.out.println("time:" + (System.currentTimeMillis() - start)));
    new TestSubscriber((Observer) subscription).awaitTerminalEvent(1000, TimeUnit.MILLISECONDS);
}