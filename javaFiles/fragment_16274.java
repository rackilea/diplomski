List<Runnable> tasks = new ArrayList<>();
tasks.add(new ThreadOne()); /* Pick better names for tasks */
tasks.add(new ThreadTwo());
...
ExecutorService worker = Executors.newSingleThreadExecutor();
worker.submit(() -> {
    while (!Thread.interrupted()) 
        tasks.forEach(Runnable::run);
});
worker.shutdown();