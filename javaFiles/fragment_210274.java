private final ReadWriteLock rwlock = new ReentrantReadWriteLock();

void a() {
    rwlock.writeLock().lock();
    try { whatever(); } finally { rwlock.writeLock().unlock(); }
}

void b() {
    rwlock.readLock().lock();
    try { whatever(); } finally { rwlock.readLock().unlock(); }
}

void c() {
    // same as b()
}