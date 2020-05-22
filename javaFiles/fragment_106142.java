ExecutorService executor = Executors.newCachedThreadPool();

    final CountDownLatch ready = new CountDownLatch(1);
    executor.execute(new Runnable() {
        @Override
        public void run() {
            // do something here
            System.out.println("working ...");
            ready.countDown();
        }
    });


    boolean timeout = !ready.await(1, TimeUnit.MILLISECONDS);
    if (timeout) {
        doSomethingElse();
    }