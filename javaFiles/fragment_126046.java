//Producer
public volatile boolean producerDone = false;
while( /* can produce more items */ ) {
    Item item=produceItem();
    synchronized(queue) {
        while(queue.size() == 10) try {
           log.debug("Queue is full, waiting");
           queue.wait();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        queue.add(item);
        queue.notifyAll();
    }
}
producerDone=true;