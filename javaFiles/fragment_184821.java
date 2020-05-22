Observable<Integer> observable = Observable.just(1, 2, 3).share();
observable.take(1).subscribe(this::runA);
observable.subscribe(
    this::runB,
    throwable -> {},
    this::runC);