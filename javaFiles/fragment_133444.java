querySubject
        .debounce(600, TimeUnit.MILLISECONDS)
        .distinctUntilChanged()
        .switchMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                  //  perform api call or any other operation here
                  return Observable.just(s);
               }
            })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);