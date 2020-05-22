ExecutorService executor = Executors.newFixedThreadPool(10);
List<Runnable> runnables = new ArrayList<Runnable> ();

for (int i = 0; i < 10; i++) {
    Runnable r = new ClassImplementingRunnable();
    runnables.add(r);
    executor.submit(r);
}

executor.shutdown();
//wait until all tasks are finished
executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

//re run the tasks sequentially
for (ClassImplementingRunnable r : runnables) {
    //the method below can access some variable in 
    //your ClassImplementingRunnable object, that was 
    //set during the first parallel run
    r.doSomethingElse(); 
}