public Single<List<Items>> dispatchStuff(){
  return mRepository.getList()
    .flatMapSingle(list ->
        list.size() > 0
        ? mRepository.operateOnList(list)
          .doOnSuccess(mRepository::deleteList)
        : Single.just(list)
    )
    .subscribeOn(mSchedulerProvider.io())
    .observeOn(mSchedulerProvider.ui());
}