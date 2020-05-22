public Observable<Location> getLocationObservable() {
        return locationPublishSubject;
}
and then...
locationPublishSubject.onNext(new Wrapper(foundLocation));

.filter(wrapper -> {
    wrapper.value != null;
})