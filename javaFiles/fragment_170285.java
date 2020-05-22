final ForkJoinWorkerThreadFactory factory = new ForkJoinWorkerThreadFactory()
{
    @Override           
    public ForkJoinWorkerThread newThread(ForkJoinPool pool)
    {
        final ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
        worker.setName("my-thread-prefix-name-" + worker.getPoolIndex());
        return worker;
    }
};

forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors(), factory, null, false);