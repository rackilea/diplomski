@Transaction
public Observable<Event> create(Event event) {

     Scheduler scheduler = Schedulers.from(Executors.newSingleThreadExecutor());
     return Observable.just(event)
            .flatMap(event -> {
                //save event to db (blocking JPA operation)
                Event event = eventRepository.save(event); 
                return Observable.just(event);
            })
            .subscribeOn(scheduler)
            //async REST call to service A
            .flatMap(this::sendEventToServiceA) <---- may execute on different thread
            //async REST call to service B
            .flatMap(this::sendEventToServiceB) <---- may execute on different thread
            .observeOn(scheduler)
            .doOnError( throwable -> {
                // ? rollback initally created transaction?
            })
}