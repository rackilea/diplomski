Observable.fromIterable(mUrls.getGroups())
    .concatMapSingle(url -> getChannels(url))
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Observer<ResponseBody>() {

         int index;  // <----------------------------------------------------

         // ...

         @Override
         public void onNext(ResponseBody responseBody) {
             Group group = GroupParser.parseList(responseBody.byteStream(), index);


             groups.put(index, group);

             index++;  // <---------------------------------------------------------
         }

         // ...
    });