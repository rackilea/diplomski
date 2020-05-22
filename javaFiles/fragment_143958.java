public Node(int element) {
    lock.lock();
    try {
        this.element = element;
    } finally {
        lock.unlock();
    }
}