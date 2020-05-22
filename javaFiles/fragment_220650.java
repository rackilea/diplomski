class OrderedTaskQueue {

    private final ReentrantLock lock;
    private final Condition waitForOrderedItem;
    private final int maxQueuesize;
    private final PriorityQueue<OrderedTask> backedQueue;

    private int expectedIndex;

    public OrderedTaskQueue(int maxQueueSize, int startIndex) {
        this.maxQueuesize = maxQueueSize;
        this.expectedIndex = startIndex;
        this.backedQueue = new PriorityQueue<>(2 * this.maxQueuesize);

        this.lock = new ReentrantLock();
        this.waitForOrderedItem = this.lock.newCondition();
    }


    public boolean put(OrderedTask item) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (this.backedQueue.size() >= maxQueuesize && item.getIndex() != expectedIndex) {
                this.waitForOrderedItem.await();
            }

            boolean result = this.backedQueue.add(item);
            this.waitForOrderedItem.signalAll();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }


    public OrderedTask take() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (this.backedQueue.peek() == null || this.backedQueue.peek().getIndex() != expectedIndex) {
                this.waitForOrderedItem.await();
            }
            OrderedTask result = this.backedQueue.poll();
            expectedIndex++;
            this.waitForOrderedItem.signalAll();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }
}