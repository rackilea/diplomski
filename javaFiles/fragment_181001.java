public class MultipleThreadWriter {

private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
private final Lock r = rwl.readLock();
private final Lock w = rwl.writeLock();


public void writeData() {

    r.lock();
    try {   
        //do write stuff    
    } finally {
        r.unlock();
    }

}

public void upgradeSystem() {

    w.lock();
    try {
        //do updates
    } finally {
        w.unlock();
    }

}
}