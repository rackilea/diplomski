lock.lock();
try {
    syncMethod2(); // throw new NullPointerException();
} finally {
    lock.unlock();
}