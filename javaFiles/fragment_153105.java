volatile SomeRef someRef = ... // important: make this volatile to deny caching
...
private void fus(){
    while (true) {
        SomeRef someRef = this.someRef;
        Lock lock = someRef.lock;
        boolean unlockNecessary = false;
        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) { // I have chonse this arbritrarily
                unlockNecessary = true;
                someRef.roh();
                return; // Job is done -> return. Remember: finally will still be executed.
                        // Alternatively, break; could be used to exit the loop.
            }
        } catch (InterruptException e) {
            e.printStackTrace();
        } finally {
            if (unlockNecessary) {
                lock.unlock();
            }
        }
    }
}
...
private void dah(){
    someRef = someOtherRef;
}