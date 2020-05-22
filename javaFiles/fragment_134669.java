Observable.concat(
    someTask, 
    Completable.fromCallable(() -> {
        System.out.println("Done");
        return null;
    }).toObservable()
);