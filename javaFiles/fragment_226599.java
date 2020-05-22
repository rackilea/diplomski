Observable.interval(10, TimeUnit.SECONDS).flatMap(new Function<Long, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Long aLong) throws Exception {
                return Observable.fromIterable(list);
            }
        });