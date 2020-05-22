protected void waitForThreadPool(final ThreadPoolTaskExecutor threadPoolExecutor)
{
    threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);
    threadPoolExecutor.shutdown();    
    try {
        threadPoolExecutor.getThreadPoolExecutor().awaitTermination(30, TimeUnit.SECONDS);
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
}   // waitForThreadPool