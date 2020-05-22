System.out.println(Thread.currentThread().getName()  + " is creating the observable");
Observable.just("747", "737", "777")
        .flatMap(a ->
                 Observable.fromCallable(() -> {
                  try {
                    System.out.println(Thread.currentThread().getName() + " is sleeping");
                    Thread.sleep(5000);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  return a;
                }).subscribeOn(Schedulers.newThread())
      ).subscribe(p -> System.out.println("Received " + p + " on thread " + Thread.currentThread().getName()));
System.out.println(Thread.currentThread().getName() + " is going to exit");