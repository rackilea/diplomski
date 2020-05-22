myObservable
    .retry(new Func2<Integer, Throwable, Boolean>() {
                @Override
                public Boolean call(Integer retryCount, Throwable throwable) {
                    return retryCount < 3 && throwable instanceof SocketTimeoutException;
                }
            })
    .subscribe(new Subscriber<Something> sub(){
        @override
        void onNext(Something something){
            //do something with something
        }
                    @override
        void onError(Throwable e){

        }