getData(source).subscribe(new BaseSubscriber<String>() {

    private int messages = 0;

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        subscription.request(1000);
    }

    @Override
    protected void hookOnNext(String value) {
        //make http request
        System.out.println(value);
        messages++;
        if(messages % 1000 == 0) {
            //when we're done with a batch
            //then we're ready to request for more
            upstream().request(1000);
        }
    }
});