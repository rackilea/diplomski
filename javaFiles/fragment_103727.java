Observable<Integer> o = Observable.merge(
    Observable.interval(2, TimeUnit.SECONDS).map(t -> setLocation),
    Observable.interval(3, TimeUnit.SECONDS).map(t -> checkWriteAttempt)
)
.map(c -> c.call())
.subscribeOn(Schedulers.single())
.observeOn(AndroidSchedulers.mainThread())
.subscribe(computationResult -> /*update UI here*/);