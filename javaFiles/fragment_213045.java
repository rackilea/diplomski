//dosent have to be files.length can be any value
ExecutorService pool = Executors.newFixedThreadPool(files.length);
//for each file
pool.execute(runnable);
//then wait until its all done
pool.awaitTermination(timeoutMillis, TimeUnit.MILLISECONDS);