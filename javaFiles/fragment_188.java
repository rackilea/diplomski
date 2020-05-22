ExecutorService pool = Executors.newFixedThreadPool(3); //number of concurrent threads

for (String name : website) { //Your ArrayList
    pool.submit(new DownloadTask(name, toPath));
}

pool.shutdown();
pool.awaitTermination(5, TimeUnit.SECONDS); //Wait for all the threads to finish, adjust as needed.