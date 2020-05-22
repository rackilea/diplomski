Observable<Account> accountObservable = Observable.create(new Observable.OnSubscribe<AccessToken>() {
    @Override public void call(Subscriber<? super AccessToken> subscriber) {
        subscriber.onNext(new AccessToken());
        subscriber.onCompleted();
    }
}).flatMap(accessToken -> Observable.create(new Observable.OnSubscribe<Account>() {
    @Override public void call(Subscriber<? super Account> subscriber) {
        subscriber.onNext(new Account(accessToken));
        subscriber.onCompleted();
    }
}));