synchronized (obj) {
    while (<condition does not hold>)
        obj.wait();
    ... // Perform action appropriate to condition
}

synchronized (obj) {
    ... // Prepare the condition
    obj.notifyAll();
}