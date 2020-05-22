Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(5));
Observable.defer(() -> {
  final Map<String, JsonElement> map = new ConcurrentHashMap<>();
  return Observable
    .from(tasks)
    .flatMap(task -> 
      Observable
        .fromCallable(task -> task.get())
        .doOnNext(mp -> map.putAll(mp)) 
        .subscribeOn(scheduler))
    .ignoreElements()
    .concatWith(Observable.just(map));
});