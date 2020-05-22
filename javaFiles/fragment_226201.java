Observable.defer(()-> Observable.just(contactUri))
.subscribeOn(Schedulers.io())
.map(t -> {
  Contact c = getContactFromDb(contactUri);
  return c;
}
// you can hand new contact directly, because PublishSubject implement Subscriber
.subscribe(contactPipe);