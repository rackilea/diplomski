/* At startup... */
ExecutorService workers = Executors.newCachedThreadPool();

/* For each request... */
Job job = ... ;
workers.submit(job); /* Assuming Job implements Runnable */
// workers.submit(job::jobEntryPoint); /* If Job has some other API */

/* At shutdown... */
workers.shutdown();