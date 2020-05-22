ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 1000; i++) {
        Runnable worker = new WorkerThread('' + i);
        executor.execute(worker);
    }
    executor.shutdown();
    while (!executor.isTerminated()) {
    }