List<Observable<String>> requests = new ArrayList<>();
    requests.add(getNameRequest());
    requests.add(getSessionIdRequest());

    Observable.zip(requests, new Function<Object[], Object[]>() {
        @Override
        public Object[] apply(Object[] objects) throws Exception {
            return new Object[]{objects[0], objects[1]};
        }
    }).subscribeWith(new DisposableObserver<Object[]>() {
        @Override
        public void onNext(Object[] objects) {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    })