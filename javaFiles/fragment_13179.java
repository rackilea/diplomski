Observable<Integer> source = Observable.just(1).delay(5, TimeUnit.SECONDS);

source
.doOnSubscribe(() -> System.out.println("Starting"))
.publish(o -> 
    o.timeout(1, TimeUnit.SECONDS, Observable.<Integer>fromCallable(() -> {
        System.out.println("Spinning...");
        return null;
    })).ignoreElements().mergeWith(o)
)
.toBlocking()
.subscribe(v -> {
    System.out.println("Hide spinner if shown.");
    System.out.println(v);
});