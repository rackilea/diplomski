Observable
    .zip(
        getStrings("One", "Two")
            .subscribeOn(Schedulers.newThread()),
        getStrings("Three", "Four")
            .subscribeOn(Schedulers.newThread()),
        getStrings("Five", "Six")
            .subscribeOn(Schedulers.newThread()),
        mergeStringLists())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Observer<List<String>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<String> strings) {
            //Display the strings
        }
    });