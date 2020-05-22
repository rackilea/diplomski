public Observable<Data> getData(boolean refresh) {
    Observable<Data> obs = Observable.concat(getCache(), requestNetwork());
    if(!refresh) {
        obs = obs.first(data -> data != null);
    }
    return obs;
}