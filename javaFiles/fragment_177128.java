while (!isDone()) {
    synchronized(monitorObject) {
        try {
            monitorObject.wait();
        } catch (InterruptedException e) {
        }
    }
}