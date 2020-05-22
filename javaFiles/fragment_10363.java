final Query query = dslContext.delete(MY_TABLE).where(...);

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(new Callable<Integer>() {
    @Override
    public Integer call() {
        return query.execute();            
    }
});