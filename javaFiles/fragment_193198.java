Observable.error(new IOException())
    .retryWhen(e -> {
         System.out.println("Setting up retryWhen");
         int[] count = { 0 };
         return e
            .takeWhile(v -> ++count[0] < 3)
            .doOnNext(v -> { System.out.println("Retrying"); });
    })
    .subscribe(System.out::println, Throwable::printStackTrace);