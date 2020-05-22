Completable c = prepareCompletable()

c.doOnComplete(() -> Log.d("OkHttp", "done 1"))
    .subscribe();

c.doOnComplete(() -> Log.d("OkHttp", "done 2"))
    .subscribe();