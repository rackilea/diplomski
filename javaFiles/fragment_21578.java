mQueuedCallsRepository.getAll()
    .subscribeOn(Schedulers.io())
    .flatMap(queuedCallModels -> {
            return mQueuedCallsRepository.clear()
                    .doOnNext(aVoid -> disableReceiver(context))
                    .map( aVoid -> queuedCallModels);
    });