Observable.create( emitter -> {
    if(emitter.isDisposed()) return;

    emitter.onNext(doSomethingLong());
    emitter.onComplete();
});