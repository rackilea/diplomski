BehaviorSubject<Integer> hotObservable = BehaviorSubject.create(-1);

Observable<Integer> observable = hotObservable.distinctUntilChanged();

hotObservable.onNext(1);
hotObservable.onNext(2);
hotObservable.onNext(3);

TestSubscriber<Integer> subscriber = TestSubscriber.create();
observable.subscribe(subscriber);

subscriber.assertNoErrors();
subscriber.assertValue(3);