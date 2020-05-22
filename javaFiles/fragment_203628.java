Observable<String> myObservable = Observable.create(
        new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> o) {
                o.onNext("hello world");
                o.onCompleted();
            }
        }
);