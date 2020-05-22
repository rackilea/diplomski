Future<FeaturedItemList> makeAsyncNetworkRequest() {
    ... initiate network request here ...
}

Observable<FeaturedItemList> getFromNetwork() {
    return Observable.fromCallable(this::makeAsyncNetworkRequest)
        .flatMap(Observable::fromFuture);
}