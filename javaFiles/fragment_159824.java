Observable.defer(() -> {
    AsyncSubject<DTOCompaniesCallback> async = AsyncSubject.create();
    modelTrainStrike.getCompaniesFromServer(v -> {
        async.onNext(v);
        async.onComplete();
    });
    return async;
})
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
...