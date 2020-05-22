// Create a thread pool
ExecutorService executor = Executors.newFixedThreadPool(threadsCount);

// Submit your tasks to the pool:
for (Count c: myCounts) {
    executor.submit(c);
}

// Shutdown the pool when you don't need it
executor.shutdown();