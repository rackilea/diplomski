ExecutorService executor = Executors.newCachedThreadPool();
Future<Integer> f = executor.submit(new Callable<Integer>()
{
    public Integer call()
    {
        return 2;
    }
});