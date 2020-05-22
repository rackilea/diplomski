Scheduler scheduler = Schedulers.from(Executors.newCachedThreadPool(new ThreadFactory() {
    @Override public Thread newThread(Runnable r) {
        Thread result = new Thread(r);
        //result.setDaemon(true);
        return result;
    }
}));

Observable.just(1, 2, 3)
        .subscribeOn(scheduler)
        .subscribe(v -> print(v));