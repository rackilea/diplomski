Observable.concat(
    someTask, 
    Completable.fromAction(() -> {
        System.out.println("Done");
    }).toObservable()
);