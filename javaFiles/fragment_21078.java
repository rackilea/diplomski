public static void main(String[] args) {
    Observable<String> stringObservable = Observable.just("e1", "e2", "e3");

    stringObservable
    .flatMap(x ->
        Observable.fromArray(x.split(""))
        .doOnNext(n -> 
            System.out.println(n)) // <-------------------- prints each split item
        .map(n->n)
        .doOnComplete(() -> 
            System.out.println(
               "Element " + x + " consumed")) // <--------- end of processing of x
    )
    .observeOn(Schedulers.io())
    .blockingSubscribe(getObserver());
}