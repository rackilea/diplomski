Object lock = new Object();
Object oldlock = lockCache.putIfAbsent(payment.getOrder().getUid(), lock);
if (oldlock != null) {
    lock = oldlock;
}

synchronized(lock) {
    // ...
}