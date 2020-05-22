final TimeoutThreadPoolExecutor executorService = new TimeoutThreadPoolExecutor(
    100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),
    6, TimeUnit.SECONDS);
executorService.submit(new Callable<Object>()
{
    @Override
    public Object call() throws Exception
    {
        Thread.sleep(5000);
        System.out.println("Done");
        return null;
    }

});

executorService.shutdown();
executorService.awaitTermination(1, TimeUnit.DAYS);
System.out.println("Program done");