//Consumer
while(!producerDone) {
    Item item;
    synchronized(queue) {
        while(queue.isEmpty()) try {
            log.debug("Queue is empty, waiting");
            queue.wait();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        item = queue.remove();
        queue.notifyAll();
    }
    processItem(item);
}