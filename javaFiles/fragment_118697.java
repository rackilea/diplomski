CountDownLatch cdl = new CountDownLatch(1);

Flux.just(1, 2, 3, 4, 5)
        .delayElements(Duration.ofMillis(500))
        .doFinally(s -> cdl.countDown())
        .subscribe(System.out::println);

cdl.await();