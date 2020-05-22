ExecutorService executor = Executors.newCachedThreadPool();

    Future<String> future = executor.submit( new Callable<String>() {
        public String call() throws Exception {
            return someVeryLengthMethod();
        }});

    String result = null;
    try {
        result = future.get(2, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
        // Somebody interrupted us
    } catch (ExecutionException e) {
        // Something went wring, handle it...
    } catch (TimeoutException e) {
        // Too long time
        future.cancel(true);
    }
    // Continue with what we have...