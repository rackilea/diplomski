public Observable<Data> getData(){
    return Observable.fromCallable(() -> {
        Data result = null;
        //do something, get your Data object
        return result;
    });
}