haveRetriedOnce = false;

 Observable.just(someInt)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap(integer ->{
          if(integer == 0){
            if(haveRetriedOnce){
               return Observable.error(new UserOperationException());
            }
            // problem, throw an error and the .retryWhen will catch it
            return Observable.error(new InvalidTokenException());
          }else{
            return Observable.just(integer);
          }
        })
        .retryWhen(observable -> observable.flatMap(throwable->{
          if(throwable instanceOf InvalidTokenException){
            haveRetriedOnce = true;
            return just(0); // retry, the int here is irrelevant
          }else{
            // other error, pass it further
            return Observable.error(throwable);
          }
        }))
        .subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                log("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                log("onError");
            }

            @Override
            public void onNext(Integer integer) {
                log("onNext - " + integer);
            }
        }