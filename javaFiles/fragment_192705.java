static ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

Document downloadPageAsDocument(String url) throws IOException {
    AtomicLong waitTime = new AtomicLong(MILLIS_PER_SECOND);
    try {
        while (waitTime.get() < MILLIS_PER_HOUR) {
            System.out.println("iteration wait=" + waitTime.get());
            ScheduledFuture<String> future = exec.schedule(() -> {
                try {
                    return jsoupCall();
                } catch (IOException ex) {
                    waitTime.getAndUpdate((l) -> l * 2);
                }
                return null;
            }, waitTime.get(), TimeUnit.MILLISECONDS);
            if (future.get() != null) { // wait for completion
                break; //break if jsoupCall was successful
            }
        }
    } catch (InterruptedException | ExecutionException e) {
        // handle exceptions
    }
}