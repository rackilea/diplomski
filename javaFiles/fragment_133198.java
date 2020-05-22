static Observable<Integer> ratesFromNetwork(Scheduler scheduler) {
    return Observable.<Integer>create(sub -> {
        sub.onNext(2);
        sub.onCompleted();
    }).delay(99, TimeUnit.MILLISECONDS, scheduler);
}

static Observable<Integer> latestRatesFromDB(Scheduler scheduler) {
    return Observable.<Integer>create(sub -> {
        sub.onNext(1);
        sub.onCompleted();
    }).delay(99, TimeUnit.MILLISECONDS, scheduler);
}