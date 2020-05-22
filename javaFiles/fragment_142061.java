ExecutorService service = Executors.newSingleThreadExecutor();
    long start = System.currentTimeMillis();
    Future<?> future = service.submit(th1);
    try {
        future.get();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
    System.out.println("time: " + (System.currentTimeMillis() - start));
    service.shutdown();