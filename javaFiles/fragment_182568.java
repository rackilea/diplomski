// bad variant of thread 2, after, let's say 500 ms
synchronized (obj) {
    obj.notify();

    // do complex operation, taking more than few ms,
    // maybe a heavy SQL query/update...
}