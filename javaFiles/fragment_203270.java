public void test() throws InterruptedException, ExecutionException
{   
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() {
            return 2;
        }
    };
    Future<Integer> future = executor.submit(callable);
    // future.get() returns 2 or raises an exception if the thread dies, so safer
    executor.shutdown();
}