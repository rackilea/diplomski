@Override
protected void bindIntents() {
        Observable<CheckinViewState> checkinViewStateObservable =
                intent(CheckinView::sendCheckin)
                        .flatMap(checkinIntent -> imageRepository.uploadImage(checkinIntent.getSignature()
                                                                 .map(imageResponse -> Pair.create(checkinIntent, imageResponse))) // Returns a Pair<CheckinIntent, CnhImageResponse>
                        .flatMap(pair ->  bookingRepository.doCheckin(pair.first) <-- Now you can access the pair holding both information
                                .subscribeOn(Schedulers.from(threadExecutor))
                                .map(CheckinViewState.Success::new)
                                .cast(CheckinViewState.class)
                                .startWith(new CheckinViewState.LoadingState())
                                .onErrorReturn(CheckinViewState.ErrorState::new))
                        .observeOn(postExecutionThread.getScheduler());

        subscribeViewState(checkinViewStateObservable, CheckinView::render);
}