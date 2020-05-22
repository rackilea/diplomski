public static void release_lock() {
    synchronized(lock) {            
        lock.notifyAll();
        lock = 0;
    }
}