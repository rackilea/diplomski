public Completable doAuth(){
    return Completable.create(subscriber -> {
        //do auth
        if(authOk) subscriber.onCompleted();
        else subscriber.onError(throwable);
    });
}