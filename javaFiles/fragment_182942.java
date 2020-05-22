public LiveData<Boolean> insert(final User user){
    MutableLiveData<Boolean> isComplated = new MutableLiveData<>();

    Completable.fromAction(() -> userDb.userDao().insert(user))
    .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                isComplated.setValue(true);
                Toast.makeText(ctx,"Data inserted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(ctx,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    return isComplated;
}