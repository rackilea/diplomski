Observable<String> obs = Observable.using(
    // resource factory:
    () -> new Timer(),
    // observable factory:
    timer -> Observable.create(subscriber -> {
        TimerTask task = new TimerTask() {
            public void run() {
                subscriber.onNext("tick! tack!");
            }
        };
        timer.scheduleAtFixedRate(task, 0L, 1000L);
    }),
    // dispose action:
    timer -> timer.cancel()
);