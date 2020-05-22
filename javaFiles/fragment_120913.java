message
    .map(this::processMessage)
    .doOnError(throwable -> Log.e(TAG, "Throwable " + throwable.getMessage()))
    .subscribe(
         System.out::println,
         error -> System.out.println("Error!")
     );