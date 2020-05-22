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

        System.out.println("Before execution of threads");

        List<Future<Integer>> futures = executor.invokeAll(callables);

        for(Future future : futures ){
            System.out.println("Futures in ArrayList: " + future.get());
        }
    }