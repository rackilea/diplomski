ExecutorService es = Executors.newCachedThreadPool();
for(int i=0;i<5;i++)
    es.execute(new Runnable() { /*  your task */ });
es.shutdown();
boolean finished = es.awaitTermination(1, TimeUnit.MINUTES);
// all tasks have finished or the time has been reached.