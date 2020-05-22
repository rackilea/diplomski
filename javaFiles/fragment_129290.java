// Thread #1
String LOCK1 = "mylock";
synchronized (LOCK1) {
}

// Thread #2
String LOCK2 = "mylock";
synchronized (LOCK2) {
    // This is actually the SAME lock,
    // might cause deadlock between the 2 synchronized blocks!
    // Because LOCK1==LOCK2!
}