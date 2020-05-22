Observable.defer(() -> {
     AtomicInteger counter = new AtomicInteger();
     return Observable.fromIterable(mUrls.getGroups())
     .map(url -> Pair.of(url, counter.getAndIncremenet()));
 })
 .flatMapSingle(urlIndex -> 
     getChannels(urlIndex.first)
     .map(v -> Pair.of(v, urlIndex.second))
     .subscribeOn(Schedulers.io())
 )
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe(new Observer<Pair<ResponseBody, Integer>>() {

         // ...

         @Override
         public void onNext(Pair<ResponseBody, Integer> pair) {
             Group group = GroupParser.parseList(pair.first.byteStream(), pair.second);


             groups.put(pair.second, group);
         }

         // ...
    });