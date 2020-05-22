public class TestThreadPoolExecutorWithTurningQueue {

    private final static Logger logger = LogManager.getLogger();

    private static ThreadPoolExecutor executorService;

    int nbRequest = 4;

    int nbThreadPerRequest = 8;

    int threadPoolSize = 5;

    private void init() {
        executorService = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 10L, TimeUnit.SECONDS,
                new CategoryBlockingQueue<Runnable>()// my custom blocking queue storing waiting tasks per request
                //new LinkedBlockingQueue<Runnable>()
        );
        executorService.allowCoreThreadTimeOut(true);
    }

    @Test
    public void test() throws Exception {
        init();
        ExecutorService tomcat = Executors.newFixedThreadPool(nbRequest);
        for (int i = 0; i < nbRequest; i++) {
            Thread.sleep(10);
            final int finalI = i;
            tomcat.execute(new Runnable() {
                @Override
                public void run() {
                    request(finalI);
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            logger.debug("TPE = " + executorService);
        }

        tomcat.shutdown();
        tomcat.awaitTermination(1, TimeUnit.DAYS);
    }

    public void request(final int requestId) {
        CustomCompletionService<Object> completionService = new CustomCompletionService<>(executorService);
        for (int j = 0; j < nbThreadPerRequest; j++) {
            final int finalJ = j;
            completionService.submit(new CategoryRunnable(requestId) {
                @Override
                public void go() throws Exception {
                    logger.debug("thread " + finalJ + " of request " + requestId + "   " + executorService);
                    Thread.sleep(2000);// here should come the useful things to be done
                }
            });
        }
        completionService.awaitCompletion();
    }

    public class CustomCompletionService<V> implements CompletionService<V> {

        private final Executor executor;

        private final BlockingQueue<Future<V>> completionQueue;

        private List<RunnableFuture<V>> submittedTasks = new ArrayList<>();

        public CustomCompletionService(Executor executor) {
            if (executor == null)
                throw new NullPointerException();
            this.executor = executor;
            this.completionQueue = new LinkedBlockingQueue<>();
        }

        public void awaitCompletion() {
            for (int i = 0; i < submittedTasks.size(); i++) {
                try {
                    take().get();
                } catch (Exception e) {
                    // Cancel the remaining tasks
                    for (RunnableFuture<V> f : submittedTasks) {
                        f.cancel(true);
                    }

                    // Get the underlying exception
                    Exception toThrow = e;
                    if (e instanceof ExecutionException) {
                        ExecutionException ex = (ExecutionException) e;
                        toThrow = (Exception) ex.getCause();
                    }
                    throw new RuntimeException(toThrow);
                }
            }
        }

        private RunnableFuture<V> newTaskFor(Callable<V> task) {
            return new FutureTask<V>(task);
        }

        private RunnableFuture<V> newTaskFor(Runnable task, V result) {
            return new FutureTask<V>(task, result);
        }

        public Future<V> submit(CategoryCallable<V> task) {
            if (task == null) throw new NullPointerException();
            RunnableFuture<V> f = newTaskFor(task);
            executor.execute(new CategorizedQueueingFuture(f, task.getCategory()));
            submittedTasks.add(f);
            return f;
        }

        public Future<V> submit(CategoryRunnable task, V result) {
            if (task == null) throw new NullPointerException();
            RunnableFuture<V> f = newTaskFor(task, result);
            executor.execute(new CategorizedQueueingFuture(f, task.getCategory()));
            submittedTasks.add(f);
            return f;
        }

        public Future<V> submit(CategoryRunnable task) {
            return submit(task, null);
        }

        @Override
        public Future<V> submit(Callable<V> task) {
            throw new IllegalArgumentException("Must use a 'CategoryCallable'");
        }

        @Override
        public Future<V> submit(Runnable task, V result) {
            throw new IllegalArgumentException("Must use a 'CategoryRunnable'");
        }

        public Future<V> take() throws InterruptedException {
            return completionQueue.take();
        }

        public Future<V> poll() {
            return completionQueue.poll();
        }

        public Future<V> poll(long timeout, TimeUnit unit)
                throws InterruptedException {
            return completionQueue.poll(timeout, unit);
        }

        /**
         * FutureTask extension to enqueue upon completion + Category
         */
        public class CategorizedQueueingFuture extends FutureTask<Void> {

            private final Future<V> task;

            private int category;

            CategorizedQueueingFuture(RunnableFuture<V> task, int category) {
                super(task, null);
                this.task = task;
                this.category = category;
            }

            protected void done() {
                completionQueue.add(task);
            }

            public int getCategory() {
                return category;
            }
        }
    }

    public abstract class CategoryRunnable implements Runnable {

        private int category;

        public CategoryRunnable(int category) {
            this.category = category;
        }

        public int getCategory() {
            return category;
        }

        void go() throws Exception {
            // To be implemented. Do nothing by default.
            logger.warn("Implement go method !");
        }

        @Override
        public void run() {
            try {
                go();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract class CategoryCallable<V> implements Callable<V> {

        private int category;

        public CategoryCallable(int category) {
            this.category = category;
        }

        public int getCategory() {
            return category;
        }
    }

    public class CategoryBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E> {

        /**
         * Lock held by take, poll, etc
         */
        private final ReentrantLock takeLock = new ReentrantLock();

        /**
         * Wait queue for waiting takes
         */
        private final Condition notEmpty = takeLock.newCondition();

        /**
         * Lock held by put, offer, etc
         */
        private final ReentrantLock putLock = new ReentrantLock();

        private Map<Integer, LinkedBlockingQueue<E>> map = new ConcurrentHashMap<>();

        private AtomicInteger count = new AtomicInteger(0);

        private LinkedBlockingQueue<Integer> nextCategories = new LinkedBlockingQueue<>();

        @Override
        public boolean offer(E e) {
            CustomCompletionService.CategorizedQueueingFuture item = (CustomCompletionService.CategorizedQueueingFuture) e;
            putLock.lock();
            try {
                int category = item.getCategory();
                if (!map.containsKey(category)) {
                    map.put(category, new LinkedBlockingQueue<E>());
                    if (!nextCategories.offer(category)) return false;
                }
                if (!map.get(category).offer(e)) return false;
                int c = count.getAndIncrement();
                if (c == 0) signalNotEmpty();// if we passed from 0 element (empty queue) to 1 element, signal potentially waiting threads on take
                return true;
            } finally {
                putLock.unlock();
            }
        }

        private void signalNotEmpty() {
            takeLock.lock();
            try {
                notEmpty.signal();
            } finally {
                takeLock.unlock();
            }
        }

        @Override
        public E take() throws InterruptedException {
            takeLock.lockInterruptibly();
            try {
                while (count.get() == 0) {
                    notEmpty.await();
                }
                E e = dequeue();
                int c = count.decrementAndGet();
                if (c > 0) notEmpty.signal();
                return e;
            } finally {
                takeLock.unlock();
            }
        }

        private E dequeue() throws InterruptedException {
            Integer nextCategory = nextCategories.take();
            LinkedBlockingQueue<E> categoryElements = map.get(nextCategory);
            E e = categoryElements.take();
            if (categoryElements.isEmpty()) {
                map.remove(nextCategory);
            } else {
                nextCategories.offer(nextCategory);
            }
            return e;
        }

        @Override
        public E poll(long timeout, TimeUnit unit) throws InterruptedException {
            E x = null;
            long nanos = unit.toNanos(timeout);
            takeLock.lockInterruptibly();
            try {
                while (count.get() == 0) {
                    if (nanos <= 0) return null;
                    nanos = notEmpty.awaitNanos(nanos);
                }
                x = dequeue();
                int c = count.decrementAndGet();
                if (c > 0) notEmpty.signal();
            } finally {
                takeLock.unlock();
            }
            return x;
        }

        @Override
        public boolean remove(Object o) {
            if (o == null) return false;
            CustomCompletionService.CategorizedQueueingFuture item = (CustomCompletionService.CategorizedQueueingFuture) o;
            putLock.lock();
            takeLock.lock();
            try {
                int category = item.getCategory();
                LinkedBlockingQueue<E> categoryElements = map.get(category);
                boolean b = categoryElements.remove(item);
                if (categoryElements.isEmpty()) {
                    map.remove(category);
                }
                if (b) {
                    count.decrementAndGet();
                }
                return b;
            } finally {
                takeLock.unlock();
                putLock.unlock();
            }
        }

        @Override
        public E poll() {
            return null;
        }

        @Override
        public E peek() {
            return null;
        }

        @Override
        public void put(E e) throws InterruptedException {

        }

        @Override
        public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public int drainTo(Collection<? super E> c) {
            return 0;
        }

        @Override
        public int drainTo(Collection<? super E> c, int maxElements) {
            return 0;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public int size() {
            return count.get();
        }

        @Override
        public int remainingCapacity() {
            return 0;
        }

    }

}