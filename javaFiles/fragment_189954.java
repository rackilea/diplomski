Flowable.just(1,2,3,4,5,6) // Completes in 1 + 6 * 3 = 19 secs
    .concatMapEager(v->
            Flowable.just(v)
            .subscribeOn(Schedulers.io())
            .map(  e->{
                System.out.println(getElapsed("Req " + e + " started");
                Thread.sleep(1000); // Network: 1 sec
                System.out.println(getElapsed("Req " + e + " done");
                return e;
            }, requestsOnWire, 1) // requestsOnWire = K = 2
           .blockingSubscribe(new DisposableSubscriber<Integer>() {
        @Override
        protected void onStart() {
            request(1);
        }
        @Override
        public void onNext(Integer s) {
            request(1);
            System.out.println("Proc " + s + " started");
            try {
                Thread.sleep(3000); // Compute: 3 secs
                System.out.println("Proc " + s + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onError(Throwable t) {

        }
        @Override
        public void onComplete() {

        }
    });