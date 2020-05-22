Observable.create((ObservableEmitter<Event> e) -> {
    Worker worker = Schedulers.io().createWorker();
    e.setDisposable(worker);

    eventSource.onEvent(es ->
        worker.schedule(() -> e.onNext(es))
    );
});