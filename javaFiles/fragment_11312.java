Map<String, Report> jobs = new ConcurrentHashMap<>();
ExecutorService executorService = Executors.newFixedThreadPool(10); //just an example

public String runReport {

    // Run the the runnable
    Report report = new Report();

    //For a numeric sequence, you can use something like AtomicLong
    String jobId = UUID.randomUUID().toString();
    jobs.put(jobId, report);

    //using a thread pool may be a better idea.
    executorService.submit(report);

    // return the job ID
    return jobId;
}