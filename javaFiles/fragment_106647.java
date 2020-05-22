@Override
 protected void bindIntents() {
        Observable<CheckinViewState> checkinViewStateObservable =
                intent(CheckinView::sendCheckin)
                        .flatMap(checkinIntent -> { 
                          return imageRepository.uploadImage(checkinIntent.getSignature()
                                                .flatMap(imageResponse ->  bookingRepository.doCheckin(command) <-- Now you have access to both, command and CnhImageResponse 
                         }) 
                         .subscribeOn(Schedulers.from(threadExecutor))
                         .map(CheckinViewState.Success::new)
                         .cast(CheckinViewState.class)
                         .startWith(new CheckinViewState.LoadingState())
                         .onErrorReturn(CheckinViewState.ErrorState::new))
                         .observeOn(postExecutionThread.getScheduler());

        subscribeViewState(checkinViewStateObservable, CheckinView::render);
}