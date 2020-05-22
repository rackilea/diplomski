public void multiThreadTest() throws InterruptedException {
    ThreadPoolExecutor readExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    List<String> files = listFiles(new File("/Users/admin/filesList"), new ArrayList<>());
    for (String file : files) {
        readExecutor.execute(new FileParser(file));
    }

    readExecutor.shutdown();
    readExecutor.awaitTermination(5, TimeUnit.MINUTES); // wait for tasks to complete
    readExecutor.shutdownNow();
}