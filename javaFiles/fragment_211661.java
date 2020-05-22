private Queue<Product> q = ...;
private Object lock = new Object();

void produceSomething(...) {
    Product p = reallyProduceSomething();
    synchronized(lock) {
        q.add(p);
        lock.notify();
    }
}

void consumeSomething(...) {
    Product p = null;
    synchronized(lock) {
        while (q.peek() == null) {
            lock.wait();
        }
        p = q.remove();
    }
    reallyConsume(p);
}