PublishSubject<String> subject = PublishSubject.create();
subject
  .switchMap(
    x -> networkOperationObservable(x)
           .subscribeOn(Schedulers.io))
  .subscribe(subscriber);