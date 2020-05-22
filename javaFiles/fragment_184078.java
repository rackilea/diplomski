Observable<Long> o = Observable.defer(() ->
    Observable.just(System.currentTimeMillis()).delay(1, TimeUnit.SECONDS))
.share();

o.subscribe(System.out::println);   // T = 0
Thread.sleep(500);
o.subscribe(System.out::println);  // T = 500
Thread.sleep(450);
o.subscribe(System.out::println);   // T = 950

Thread.sleep(550);
o.subscribe(System.out::println);   // T = 1500
Thread.sleep(500);
o.subscribe(System.out::println);   // T == 2000

Thread.sleep(1000);