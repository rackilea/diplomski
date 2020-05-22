public void loadImages(String id) {
    checkViewAttached();
    Subscription subscription = mDataManager.getMovieImages(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                 getMvpView()::showImages,
                 { error -> error.printStackTrace() }
            );
    mSubscriptions.add(subscription);
}