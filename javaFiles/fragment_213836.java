Observable.fromCallable(() -> Thread.currentThread())
.subscribeOn(Schedulers.single())
.subscribe(System.out::println);

System.out.println("Subscriber thread: " + Thread.currentThread());

Thread.sleep(1000);