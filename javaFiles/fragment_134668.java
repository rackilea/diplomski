Observable.concat(
    someTask, 
    Completable.fromRunnable(() -> {
        System.out.println("Done");
    }).toObservable()
);