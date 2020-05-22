query = apiService.getObjects(token)
            .compose(bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .cache();

query.observeOn(AndroidSchedulers.mainThread())
            .subscribe(o -> {
                // process in Main Thread
            })
query.observeOn(Schedulers.io())
            .subscribe(o -> {
                // process in the background thread
            });