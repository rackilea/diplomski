Set<String> uniqueQueue = Sets.newConcurrentHashSet();
ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, Queues.newLinkedBlockingQueue(100));
ListeningExecutorService executorService = MoreExecutors.listeningDecorator(threadPoolExecutor);

String t1 = "abc";
if(uniqueQueue.add(t1)) {
    ListenableFuture<String> future = executorService.submit(() -> "do something with " + t1);
    Futures.addCallback(future, new FutureCallback<String>() {
        @Override
        public void onSuccess(String result) {
            uniqueQueue.remove(t1);
        }

        @Override
        public void onFailure(Throwable t) {
            uniqueQueue.remove(t1);
        }
    });
}