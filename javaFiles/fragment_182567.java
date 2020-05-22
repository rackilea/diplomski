// thread 1
synchronized (obj) {
    // wait 1000ms
    obj.wait(1000);
}
// check for overwait

// thread 2, after, let's say 500 ms
synchronized (obj) {
    obj.notify();
}