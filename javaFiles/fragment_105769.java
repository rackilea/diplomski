private void functionB() {
    writeLock.lock();
    try {
       // do the B processing here ...
    } finally {
       writeLock.unlock();
    }
}