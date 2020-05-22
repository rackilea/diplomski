Observable.defer(() -> getMyObservable(params))
.retryWhen(errors -> {
    AtomicInteger count = new AtomicInteger();
    return errors.flatMap(error -> {
       if (error.toString().contains("401")) {
           int c = count.incrementAndGet();
           if (c <= 5) {
               return Observable.timer(c, TimeUnit.SECONDS);
           }
           return Observable.error(new Exception("Failed after 5 retries"));
       }
       return Observable.error(error);
    })
})