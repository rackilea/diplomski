Lock lock = new ReentrantLock();

public void doWorkIfNotBusy() {
    if (lock.tryLock()) {
        try {
            // do work
         } finally {
             lock.unlock();
         }
     } 
}