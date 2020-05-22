public E poll() {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        return q.poll();
    } finally {
        lock.unlock();
    }
}