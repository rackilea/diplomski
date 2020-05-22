public void log(String msg) throws InterruptedException {
     if(!shutdownRequested) {//A. 1001 threads see shutdownRequested as false and pass the if condition.

           //B. At this point, shutdownRequested is set to true by client code
           //C. Meanwhile, the LoggerThread which is the consumer sees that shutdownRequested is true and calls 
           //queue.drainTo to drain all existing messages in the queue instead of `queue.take`. 
           //D. Producers insert the new message into the queue.    
           queue.put(msg);//Step E
     } else
           throw new IllegalArgumentException("logger is shut down");
     }
}