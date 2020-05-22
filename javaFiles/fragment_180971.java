public synchronized void add(String item){
    if(eventQueue.remainingCapacity() == 0)
    {
        es.execute(new EventConsumerTask(eventQueue)); 
    }
    waitUntilQueueHasCapacityAgain();
    eventQueue.add(item);
}