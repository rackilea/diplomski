private static <T> Subscription subscribe(Subscriber<? super T> subscriber, Observable<T> observable) {
    ...
        if(!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber((Subscriber)subscriber);
        }
    ...
    }
}