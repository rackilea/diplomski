RxSearchView.queryTextChanges(searchView)
            .debounce(400, TimeUnit.MILLISECONDS)
            .map(CharSequence::toString)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .switchMap(query -> retrofitService.search(query))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<List<Item>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    Log.e(LOG_TAG, "Error", e);
                }

                @Override
                public void onNext(List<Item> items) {
                    // adapter.addItems(...)
                }
            });