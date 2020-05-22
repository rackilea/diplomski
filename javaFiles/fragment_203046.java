Completable.defer(() -> auth()).andThen(call())
                .retryWhen(throwableFlowable -> throwableFlowable.flatMap(throwable -> {
                    System.out.println("Retrying...\n");
                    return Flowable.timer(1, TimeUnit.SECONDS);
                }))
                .subscribe(integer -> System.out.println("Result: " + integer), e -> System.out.println("Error" + e.getMessage()));