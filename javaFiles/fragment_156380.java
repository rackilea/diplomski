class MyCustomException extends Exception {
    Result result;
}

//do you really need switchMap?
.flatMap(result -> {
    if (result.success()) {
        return Observable.just(result.getResource());
    } else {
        return Observable.error(MyCustomException(result));
    }
})
//do* operators is meant to call side effect methods without changing the stream
.doOnError(exception -> { 
    if(exception instanceof MyCustomException) {
        Result result = ((MyCustomException) exception).getResult();
        onFailure(result);
    }
})
.onErrorResumeNext(exception -> {
    if(exception instanceof MyCustomException) {
        return Observable.empty();
    } else {
        return Observable.error(exception); //propagate error downstream
    }
})