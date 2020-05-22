ListeningExecutorService executor = ...
Striped<Lock> locks = Striped.lock(256);
ConcurrentMap<String, ListenableFuture<?>> dispatchQueues = ...

public ListenableFuture<?> dispatch(String queueName, final Runnable task) {
  Lock lock = locks.get(queueName);
  lock.lock();
  try {
    ListenableFuture<?> future = dispatchQueues.get(queueName);
    if (future == null) {
      future = executor.submit(task);
    } else {
      final SettableFuture<Void> next = SettableFuture.create();
      future.addListener(new Runnable() {
        try {
          task.run();
        } finally {
          next.set(null);
        }
      }, executor);
      future = next;
    }
    dispatchQueues.put(queueName, future);
  } finally {
    lock.unlock();
  }
}