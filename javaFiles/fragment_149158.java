Subject<Integer> subject = PublishSubject.create();
    subject.subscribe(new Consumer<Integer>() {
        @Override
        public void accept(@NonNull Integer integer) throws Exception {
            System.out.println("item = " + integer);
        }
    });
    Observable.just(1,2).doOnNext(new Consumer<Integer>() {
        @Override
        public void accept(@NonNull Integer e) throws Exception {
            subject.onNext(e);
        }
    }).subscribe();

    subject.onNext(3);