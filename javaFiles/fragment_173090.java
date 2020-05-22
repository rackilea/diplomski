private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main (String[] args) throws ExecutionException, InterruptedException {

        ArrayList futureObjects = new ArrayList();

        Callable<Integer> task = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(task);
        callables.add(task);
        callables.add(task);
        callables.add(task);
        //Add other tasks

        List<Future<Integer>> futures = new ArrayList<>();
        System.out.println("Before execution of threads");

        for(Callable<Integer> callable : callables) {
            futures.add(executor.submit(callable));
        }

        for(Future future : futures ){
            System.out.println("Futures in ArrayList: " + future.get());
        }
    }