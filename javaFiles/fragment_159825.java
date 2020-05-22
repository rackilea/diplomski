Observable.defer(() -> {
    AsyncSubject<DTOCompaniesCallback> async = AsyncSubject.create();
    Closeable c = modelTrainStrike.getCompaniesFromServer(v -> {
        async.onNext(v);
        async.onComplete();
    });
    return async.doOnUnsubscribe(() -> {
        try { c.close(); } catch (IOException ex) { }
    });
})