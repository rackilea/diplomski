private <T> Observable<T> attachErrorHandler(Observable<T> obs) {
    return obs.onErrorResumeNext(throwable -> {
        System.out.println("Handling error by printint to console: " + throwable);
        return Observable.empty();
    });
}

// Use like this:
Observable<String> unsafeObs = getErrorProducingObservable(); 
Observable<String> safeObservable = attachErrorHandler(unsafeObs);
// This call will now never cause OnErrorNotImplementedException
safeObservable.subscribe(s -> System.out.println("Result: " + s));