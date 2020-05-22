Observable.mergeDelayError(
            Observable.just(null)
                    .doOnNext(x -> {
                        throw new RuntimeException();
                    }),
            Observable.just(1).delay(70, TimeUnit.MILLISECONDS),
            Observable.just(2).delay(50, TimeUnit.MILLISECONDS))
            .take(1)
            .subscribe(System.out::print);