// if no emissions are made for a period of 3 seconds - will call onError
observableWithCache.timeout(3000, TimeUnit.MILLISECONDS).subscribe(new Subscriber<SomeObject>() {

    public void onCompleted() {

    }

    public void onError(Throwable arg0) {
        doClearCache(); // make sure to re-subscribe with timeout
    }

    public void onNext(SomeObject item) {
        System.out.println("Got item: " + item); // you can ignore this
    }
});