Observable.create(new Observable.OnSubscribe<Void>() {
    @Override
    public void call(Subscriber<? super Void> subscriber) {
        Subscriber yourSubscriber = ((SafeSubscriber) subscriber).getActual();
        ((MySubscriber) yourSubscriber).onMessage("100%");
        ((MySubscriber) yourSubscriber).onDownloaded(file);
    }
});