public synchronized void put(int value) {
        while (process >= 1000) {
            .....
            notifyAll();
        }
}