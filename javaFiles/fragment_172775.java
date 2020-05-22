public Single<Data> getData() {
        return Single.create(singleSubscriber -> {
            Data result = object.getData();
            if(result == null){
                singleSubscriber.onError(new Exception("no data"));
            } else {
                singleSubscriber.onSuccess(result);
            }
        });
    }

getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(data -> {
                //do something with your data
            }, error -> {
                //do something on error
            });