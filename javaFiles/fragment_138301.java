private final ReadWriteLock lock = new ReentrantReadWriteLock();


    final Lock w = lock.writeLock();
    w.lock();
    try {
        // modifications of the list
    } finally {
        w.unlock();
    }

      .................................

    final Lock r = lock.readLock();
    r.lock();
    try {
        // read-only operations on the list
        // e.g. copy it to an array
    } finally {
        r.unlock();
    }
    // and iterate outside the lock