Observable.from(urls)
    .concatMapDelayError(url -> downloadObservable(url))
    .doOnError(error -> {
        if (error instanceof CompositeException) {
           System.out.println(((CompositeException)error).getExceptions().size());
        } else {
            System.out.println(1);
        }
    });