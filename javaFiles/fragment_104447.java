final Lock lock = new ReentrantLock(true);

// thread A
lock.lock();
// write to list
lock.unlock();

// thread B
lock.lock();
// read from list
lock.unlock();