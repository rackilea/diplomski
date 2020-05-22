while(!ThreadCounter.cancel) {
    int threadCount = ThreadCounter.threadCounter.decrementAndGet(); // decrement before blocking
    if(threadCount == 0 && ThreadCounter.queueCounter.get() == 0) {
        ThreadCounter.cancel = true;
        queue.offer(ThreadCounter.poisonPill);
    } else {
        Object obj = queue.take();
        ThreadCounter.threadCounter.incrementAndGet(); // increment when the thread is no longer blocking
        ThreadCounter.queueCounter.decrementAndGet();
        if(obj == ThreadCounter.poisonPill) {
            queue.offer(obj); // send the poison pill back through the queue so the other threads can read it
            continue;
        }
    }
}