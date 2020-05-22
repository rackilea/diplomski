Observable.just(1).flatMap(new Func1<Integer, Observable<Integer>>() {

        @Override
        public Observable<Integer> call(Integer initialValue) {
            return ViewObservable.clicks(button, false)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .scan(initialValue, new Func2<Integer, View, Integer>() {

                        @Override
                        public Integer call(Integer integer, View v) {
                            return integer + 1;
                        }
                    });
        }
    }).subscribe(new Observer<Integer>() {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(Integer integer) {
            System.out.println(integer);
        }
    });