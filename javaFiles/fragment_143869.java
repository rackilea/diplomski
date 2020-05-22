synchronized (obj1) {
    while (<condition does not hold>)
        obj1.wait();
    ... // Perform action appropriate to condition
}

synchronized (obj2) {
    ... // call notifyAll on obj2 will not stop the wait on obj1
    obj2.notifyAll();
}