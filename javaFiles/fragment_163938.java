Observable mainObservable = Observable.just("Your main Observable");
Observable secondObservable = Observable.just("Your second Observable");

mainObservable
        .onErrorResumeNext(o1 -> secondObservable.flatMap(o2 -> mainObservable))
        .subscribe();