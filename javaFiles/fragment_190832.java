Observable.fromIterable(offerBasicListModel)
            .observeOn(Schedulers.computation())
            .filter(BasicListModel::isDownloading)
            .doOnNext(
            model ->Log.d(TAG,"filtered objects one by one ->",model.getId())
            )
            .toList()
            .subscribe(model -> Log.d(TAG, "filtered list size: "+model.size()));