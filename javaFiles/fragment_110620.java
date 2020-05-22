class DocProducer implements Runnable {
    private final BlockingQueue queue;
    Producer(BlockingQueue q) { queue = q; }
    public void run() {
        try {
            while (true) { queue.put(produce()); }
        } catch (InterruptedException ex) { ... handle ...}
    }
    Document produce() { ... }
}

class DocConsumer implements Runnable {
    private final BlockingQueue queue;
    Consumer(BlockingQueue q) { queue = q; }
    public void run() {
        try {
            while (true) { consume(queue.take()); }
        } catch (InterruptedException ex) { ... handle ...}
    }
    void consume(Document x) { ... }
}

class Setup {
    void main() {
        // or use your own thread-safe queue implementation,
        // which is harder to be right, though
        BlockingQueue printQueue = new LinkedBlockingQueue();

        DocProducer p = new DocProducer(printQueue);
        DocConsumer c1 = new DocConsumer(printQueue);
        DocConsumer c2 = new DocConsumer(printQueue);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}