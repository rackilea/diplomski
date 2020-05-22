compositeDisposable.add(
    Observable.interval(500L, TimeUnit.MILLISECONDS)
    .timeInterval()
    .observeOn(AndroidSchedulers.mainThread())
    .flatMap(longTimed -> {
        if (emissionBoolean) {
            //todo: find an observable that can emit 0 arguments
            return Observable.just(new Object());
        }
        return Observable.empty()
    })
    .subscribe(object -> { // you still need to declare though.
        onTick();
    }));