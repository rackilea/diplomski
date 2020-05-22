ExecutorService executorService = Executors.newCachedThreadPool();
Callable parentThread = () -> {
    System.out.println("In parentThread : " + Thread.currentThread().getName());
    Callable childThread = () -> {
        System.out.println("In childThread : " + 
        Thread.currentThread().getName());
        Thread.sleep(5000); // just to make sure, child thread outlive parent thread
        System.out.println("End of task for child thread");
        return 2; //ignore, no use here
    };
    executorService.submit(childThread);
    System.out.println("End of task for parent thread");
    return 1; //ignore, no use here
};
executorService.submit(parentThread);
Thread.sleep(8000); // wait until child thread completes its execution.
executorService.shutdown();