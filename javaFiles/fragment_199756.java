public <T extends ResponseTask> List<T> invokeAll(Set<Callable<ResponseTask>> callables, int threadCount) {
        ThreadFactory customThreadfactory = new CustomThreadFactoryBuilder().setNamePrefix("MultiThreadExecutor-Calls")
                        .setDaemon(false).build();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount, customThreadfactory);
        try {
            List<Future<ResponseTask>> threadResponse = executor.invokeAll(callables);
            return getResponse(threadResponse);
        } catch (InterruptedException e) {
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
        return Collections.emptyList();
    }