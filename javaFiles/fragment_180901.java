private Completable createCompletable() {
        return Single.zip(createHttpRequestOne().subscribeOn(Schedulers.newThread()),
                createHttpRequestTwo().subscribeOn(Schedulers.newThread()), (b1, b2) -> b1 && b2)
                .flatMap(new Function<Boolean, SingleSource<Boolean>>() {
                    @Override
                    public SingleSource<Boolean> apply(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            return Single.just(true);
                        } else {
                            return Single.error(new Throwable("one of the Single returned FALSE"));
                        }
                    }
                }).toCompletable();
    }