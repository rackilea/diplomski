public void function_to_parallelize(Item input, double param,...){
    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    List<Future<Tuple>> list = new ArrayList<Future<Tuple>>();

    CountDownLatch latch = new CountDownLatch(<number_of_tasks_created_in_next_loop>);

    while(some_stopping_condition){
        // extract subset of input and feed into Solver constructor below

        Callable<Tuple> worker = new Solver(input, param, W, v, toolkit,latch);

        Future<Tuple> submit = executor.submit(worker);
        list.add(submit);
    }
     latch.await();
     for(Future<Tuple> future : list){
        try {
            Item out = future.get();
            // update W via some operation using "out" (like multiplying matrices for example)
        }catch(InterruptedException e) {
            e.printStackTrace();
        }catch(ExecutionException e) {
            e.printStackTrace();
        }
    }
    executor.shutdown(); // properly terminate the threadpool
}