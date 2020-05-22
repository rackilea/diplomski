CountDownLatch latch = new CountDownLatch(3);
Mono.just(1).subscribe(
            i -> latch.countDown(),
            throwable -> {},
            latch::countDown,
            s -> {
                s.request(Long.MAX_VALUE);
                latch.countDown();
            });
boolean success = latch.await(1, TimeUnit.SECONDS);
Assert.assertEquals(true, success);