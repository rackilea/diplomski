Observable.zip(getNameRequest(), getSessionIdRequest(), new BiFunction<String, String, Object>() {
        @Override
        public Object apply(String name, String sessionId) throws Exception {
            // here you will get all the results once everything is completed. you can then take these 
            // results and transform into another object and returnm from here. I decided to transform the results into an Object[]
            // the retuen type of this apply funtion is generic, so you can choose what to return
            return new Object[]{name, sessionId};
        }
    })
    .subscribeOn(Schedulers.io())  // will start this entire chain in an IO thread
    .observeOn(AndroidSchedulers.mainThread()) // observeOn will filp the thread to the given one , so that the downstream will be executed in the specified thread. here I'm switching to main at this point onwards
    .subscribeWith(new DisposableObserver<Object>() {
        @Override
        public void onNext(Object finalResult) {
           // here you will get the final result with all the api results
        }

        @Override
        public void onError(Throwable e) {
            // any error during the entire process will be triggered here
        }

        @Override
        public void onComplete() {
             //will be called once the whole chain is completed and terminated
        }
    });