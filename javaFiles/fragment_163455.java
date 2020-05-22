synchronized (someObject) {
    someObject.wait();
}

/* different thread / object */
synchronized (someObject) {
    someObject.notify();
}