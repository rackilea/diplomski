ExecutorService exec = Executors.newCachedThreadPool();
Set<Callable<Data>> objects = //get objects;
List<Future<Data>> futures = exec.invokeAll(objects);
for(Future<Data>> future : futures){
    Data data = future.get();
    //do stuff with data
}
exec.shutdown();