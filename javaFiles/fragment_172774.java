getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(data -> {
                //do something with your data
            }, error -> {
                //do something on error
            });