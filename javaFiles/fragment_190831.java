Observable.fromIterable(offerBasicListModel)
            .observeOn(Schedulers.computation())
            .filter(new Predicate<BasicListModel>() {
                @Override
                public boolean test(BasicListModel model) throws Exception {

                    if (model.isDownloading()) //assume
                        return true; // if true, object will redirect to `doOnNext`
                    else
                        return false;
                }
            })
            .doOnNext(new Consumer<BasicListModel>() {
                @Override
                public void accept(BasicListModel model) throws Exception {
                    Log.d("objects one by one ->",model.getId());
                }
            })
            .toList()
            .subscribe(new Consumer<List<BasicListModel>>() {
                @Override
                public void accept(List<BasicListModel> model) throws Exception {
                    Log.d(TAG, "filtered list size: "+model.size());
                }
            });