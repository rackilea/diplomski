Observable<Double> creatingObservable = getCreatingObservable(image);
Subscriber<Double> creatingSubscriber = getCreatingSubscriber();

creatingObservable
        .subscribeOn(Schedulers.io())
        .subscribe(creatingSubscriber);

Thread.sleep(5000); //to wait 5 seconds while creatingObservable is running on IO thread