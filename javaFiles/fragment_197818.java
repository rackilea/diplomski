private static final int NTHREADS = 5;
private static final int NTASKS = 100;
private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

public static void main(String[] args) throws InterruptedException {
    final CompletionService<Long> ecs = new ExecutorCompletionService<Long>(exec);
    for (final int i = 0; i < NTASKS ; ++i) {
        Callable<Long> task = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return i;
            }
        };
        ecs.submit(task);
    }
    for (int i = 0; i < NTASKS; ++i) {
        try {
            long l = ecs.take().get();
            System.out.print(l);
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }
    }
    exec.shutdownNow();
    exec.awaitTermination(50, TimeUnit.MILLISECONDS);
}