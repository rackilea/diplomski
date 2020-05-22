public static Observable<String> observeRepositoryUpdates(ItemsRepository repo, Observable<Void> updateTrigger) {
  updateTrigger
    //you can insert observeOn here
    .flatMap(event -> repository.getAllItems());
}

public static void doWork() {
  ItemsRepository repo = new ItemsRepository();
  PublishSubject<Void> updateTrigger = PublishSubject.create();

  observeRepositoryUpdates(repo, updateTrigger)
    .subscribe(items -> System.out.println(items.toString());

  updateTrigger.onNext(null);//trigger update
}