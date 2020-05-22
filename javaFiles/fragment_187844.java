private class ThreadPoolManager {

        private ExecutorService executorService;
        private final Map<Future,MyRunnable> queuedFutures;
        private final BlockingQueue<Runnable> blockingQueue;

        private ThreadPoolManager() {
            MyLogger.log(DEBUG, "Threadpool-created(constructor)");
            queuedFutures = new HashMap<>();
            blockingQueue = new LinkedBlockingDeque<>();
            executorService = getNewExecutorService();
        }

        private ExecutorService getNewExecutorService() {
            return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 1, TimeUnit.SECONDS, blockingQueue);
        }

        private void submitItemTest(MyRunnable runnable) {
            MyLogger.log(DEBUG, "Threadpool-submitted item test");
            if (executorService.isShutdown()) {
                executorService = getNewExecutorService();
            }
            Future future = executorService.submit(runnable);
            queuedFutures.put(future,runnable);
        }

        private void submitTestAll(MyRunnable runnable) {
            MyLogger.log(DEBUG, "Threadpool-submitted test all");
            if (executorService.isShutdown()) {
                executorService = getNewExecutorService();
            }
            cancelAll();
            Future future = executorService.submit(runnable);
            queuedFutures.put(future,runnable);
        }

        private void cancelAll() {
            MyLogger.log(DEBUG, "ThreadPool: Cancelling all future tasks");
            blockingQueue.clear();
            for (Future future : queuedFutures.keySet()) {
                if (!future.isDone()) {
                    queuedFutures.get(future).continueRunning=false;
                    MyLogger.log(DEBUG, "Cancelled");
                }
            }
            queuedFutures.clear();
        }

        private void shutdownExecutor() {
            cancelAll();
            MyLogger.log(DEBUG, "ThreadPool: Shuttingdown threadpool");
            executorService.shutdown();
        }
    }