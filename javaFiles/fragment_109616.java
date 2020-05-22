threadPool.shutdown();
    try {
        threadPool.awaitTermination(10, TimeUnit.MINUTES);
    } catch (InterruptedException e) {               
        // Current thread was interrupted.
        final List<Runnable> runnables = threadPool.shutdownNow();
        System.out.println("Can't stop tasks: " + runnables.size());

        // Restore interrupted status.
        Thread.currentThread().interrupt();
    }