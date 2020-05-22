Observable.range(1, 10)
.flatMap(v -> 
    Observable.fromCallable(() -> compute(v))
    .subscribeOn(Schedulers.computation)
)
.subscribe(e -> { }, Throwable::printStackTrace);