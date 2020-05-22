Random r = new Random();
Observable.from(new String[]{"First", "Second", "Third", "Fourth", "Fifth"})
    .flatMap(new Func1<String, Observable<String>>() {
        public Observable<String> call(final String s) {
            return Observable.defer(new Func0<Observable<String>>() {
                public Observable<String> call() {
                    Thread.sleep(r.nextInt(1000));
                    return Observable.just(s);
                }
            }).subscribeOn(Schedulers.newThread());
        }
    })
    .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("Observed " + s + " on thread " + Thread.currentThread().getId());
        }
    });