import java.util.concurrent.locks.ReentrantReadWriteLock;

class Workflow {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void updateWorkflowConfig() {
        this.rwl.writeLock().lock();
        try {
            // do smth
        } finally {
            this.rwl.writeLock().unlock();
        }
    }

    public Work takeWorkFromWorkflow() {
        Work result = null;
        this.rwl.readLock().lock();
        try {
            result = //...
        } finally {
            this.rwl.readLock().unlock();
        }
        return result;
    }
}