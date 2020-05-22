@Test
public void testObservableAsync() throws InterruptedException {
    Subscription subscription = Observable.from(numbers)
            .doOnNext(increaseTotalItemsEmitted())
            .subscribeOn(Schedulers.newThread())
            .subscribe(number -> System.out.println("Items emitted:" + total));
    System.out.println("I finish before the observable finish.  Items emitted:" + total);


    new TestSubscriber((Observer) subscription)
            .awaitTerminalEvent(100, TimeUnit.MILLISECONDS);
}