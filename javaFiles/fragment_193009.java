private void decideQueue(String objectId) { // actually decides which thread to process it.
    Queue queue = getQueueIfObjectIdPreviouslyUsed(objectId);
    if (queue == null) {
        queue = getNextAvailableQueue();
    }

    queue.enqueue();

    //.. 
    //don't forget to dequeue from the main queue
    //..
}