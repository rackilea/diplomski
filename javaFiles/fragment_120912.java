message
    .map(this::processMessage)
    .retryWhen(errors -> errors.flatMap(error -> {  
        if (error instanceof IOException) {
          return Observable.just(null);
        }
        // For anything else, don't retry
        return Observable.error(error);
     })
     .subscribe(
         System.out::println,
         error -> System.out.println("Error!")
     );