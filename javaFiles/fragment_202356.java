CountDownLatch latch = new CountDownLatch(1);
List<Throwable> failures = new ArrayList<>();
collection.find()
        .toObservable().subscribe(
        // on next, this is invoked for each document returned by your find call
        document -> {
            // presumably you'll want to do something here to meet this requirement: "pass it on to test in JUnit5" 
            System.out.println(document);
        },
        /// on error
        throwable -> {
            failures.add(throwable);
        },
        // on completion
        () -> {
            latch.countDown();
        });
// await the completion event
latch.await();