public Completable processItems() {
    return getListOfItems()
            .toObservable()
            .flatMapIterable(items -> items)
            .flatMapCompletable(item -> doSomething(item));
}