myObservable
    .retry((retryCount, throwable) -> retryCount < 3 && throwable instanceof SocketTimeoutException)
    .subscribe(new Subscriber<Something> sub(){
        @override
        void onNext(Something something){
            //do something with something
        }
                    @override
        void onError(Throwable e){

        }