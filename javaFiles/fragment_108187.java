class DataProducer implements Runnable {
    ...
    queue.put(data); // blocks if MAX_BLOCKS_IN_QUEUE_UNTIL_BLOCK 
                     // are waiting to be written
                     // This prevents an OutOfMemoryException
    ...
 }

 class DataConsumer implements Runnable {
   ...
   try {
       while(true) {
           writeData(queue.take()); // blocks until there is a block of data
       }
   } catch (InteruptedException e) {
       Thread.currentThread().interrupt();
   }
   ...
 }