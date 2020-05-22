for (; ; ) {
    long expectedOldValue = atomic.get();
    // other threads can change the value of atomic here..

    long modified = modify(expectedOldValue);

    // we can only set the new value if the old one is still the same
    if (atomic.compareAndSet(expectedOldValue, modified)) {
        return modified;
    }
}