compositeDisposable.add(
    Observable.interval(500L, TimeUnit.MILLISECONDS)
    .timeInterval()
    .observeOn(AndroidSchedulers.mainThread())
    .flatMap {
        if (emissionBoolean) {
            Observable.just(Any())
        } else {
            Observable.empty<Any>()
        }}
    .subscribe {
        onTick()
    }