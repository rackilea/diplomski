public class RetryExecutor extends ThreadPoolExecutor {
    private final long maxRetries;
    private Map<Runnable, Integer> retries = new ConcurrentHashMap<>();

    public RetryExecutor(int corePoolSize, int maximumPoolSize, long maxRetries,
                         long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.maxRetries = maxRetries;
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new RetryFutureTask<>(runnable, value);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new RetryFutureTask<>(callable);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null && shouldRetry(r)) {
            retry(r);
        }  else if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException | ExecutionException e) {
                // you should log the error
                if (shouldRetry(r)) {
                    retry(r);
                }  else {
                    retries.remove(r);
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        } else {
            retries.remove(r);
        }
    }

    private boolean shouldRetry(Runnable r) {
        final Integer nbRetries = retries.getOrDefault(r, 0);
        return nbRetries < maxRetries;
    }

    private void retry(Runnable r) {
        final Integer nbRetries = retries.getOrDefault(r, 0);
        retries.put(r, nbRetries + 1);
        this.execute(r);
    }

    private static class RetryFutureTask<V> implements RunnableFuture<V> {
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int ERROR = 2;
        private static final int FINISHED = 3;
        private static final int INTERRUPTED = 4;
        private final AtomicInteger state = new AtomicInteger(NEW);
        private final AtomicReference<Thread> runner = new AtomicReference<>();
        private final AtomicReference<WaitNode> waiters = new AtomicReference<>();
        private final Callable<V> callable;
        private Exception error;
        private V result;

        public RetryFutureTask(Runnable runnable, V result) {
            this.callable = Executors.callable(runnable, result);
        }

        public RetryFutureTask(Callable<V> callable) {
            this.callable = callable;
        }

        @Override
        public void run() {
            try {
                // If not already running
                if (runner.compareAndSet(null, Thread.currentThread())) {
                    state.set(RUNNING);
                    result = this.callable.call();
                    state.compareAndSet(RUNNING, FINISHED);
                }
            } catch (Exception e) {
                error = e;
                state.compareAndSet(RUNNING, ERROR);
                finishCompletion();
            } finally {
                runner.set(null);
            }
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            if (state.get() == RUNNING || state.get() == INTERRUPTED) {
                return false;
            }
            try {
                Thread t = runner.get();
                if (mayInterruptIfRunning && t != null) {
                    t.interrupt();
                }
            } finally {
                state.set(INTERRUPTED);
                finishCompletion();
            }
            return true;
        }

        @Override
        public boolean isCancelled() {
            return state.get() == INTERRUPTED;
        }

        @Override
        public boolean isDone() {
            return state.get() > RUNNING;
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            if (state.get() <= RUNNING) {
                awaitDone(false, 0L);
            }
            return resolve();
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            if (state.get() <= RUNNING) {
                awaitDone(true, unit.toNanos(timeout));
            }
            return resolve();
        }

        private V resolve() throws ExecutionException, InterruptedException {
            if (state.get() == ERROR) {
                throw new ExecutionException(error);
            } else if (state.get() == INTERRUPTED) {
                throw new InterruptedException();
            }
            return result;
        }

        private void finishCompletion() {
            for (WaitNode q; (q = waiters.get()) != null;) {
                if (waiters.compareAndSet(q, null)) {
                    for (;;) {
                        Thread t = q.thread;
                        if (t != null) {
                            q.thread = null;
                            LockSupport.unpark(t);
                        }
                        WaitNode next = q.next;
                        if (next == null)
                            break;
                        q.next = null; // unlink to help gc
                        q = next;
                    }
                break;
                }
            }
        }

        private void awaitDone(boolean timed, long nanos) throws InterruptedException {
            final long deadline = timed ? System.nanoTime() + nanos : 0L;
            WaitNode q = null;
            boolean queued = false;
            for (; ; ) {
                if (Thread.interrupted()) {
                    removeWaiter(q);
                    throw new InterruptedException();
                }

                int s = state.get();
                if (s > RUNNING) {
                    if (q != null)
                        q.thread = null;
                    return;
                } else if (q == null)
                    q = new WaitNode();
                else if (!queued)
                    queued = waiters.compareAndSet(q.next, q);
                else if (timed) {
                    nanos = deadline - System.nanoTime();
                    if (nanos <= 0L) {
                        removeWaiter(q);
                        return;
                    }
                    LockSupport.parkNanos(this, nanos);
                } else
                    LockSupport.park(this);
            }
        }

        private void removeWaiter(WaitNode node) {
            if (node != null) {
                node.thread = null;
                retry:
                for (;;) {          // restart on removeWaiter race
                    for (WaitNode pred = null, q = waiters.get(), s; q != null; q = s) {
                        s = q.next;
                        if (q.thread != null)
                            pred = q;
                        else if (pred != null) {
                            pred.next = s;
                            if (pred.thread == null) // check for race
                                continue retry;
                        }
                        else if (!waiters.compareAndSet(q, s))
                            continue retry;
                    }
                    break;
                }
            }
        }

        static final class WaitNode {
            volatile Thread thread;
            volatile WaitNode next;
            WaitNode() { thread = Thread.currentThread(); }
        }
    }
}