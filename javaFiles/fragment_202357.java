mydatabase.getCollection("testcollection").find()
        .toObservable().subscribe(
        document -> {
            doTest(process(document));
        },
        throwable -> {
            failures.add(throwable);
        },
        () -> {
            latch.countDown();
        });
latch.await();