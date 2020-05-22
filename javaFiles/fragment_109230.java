public synchronized void put(Bread b) throws InterruptedException {
    while (breadList.size() == 20) {
        wait();
    }
    breadList.add(b);
    notifyAll();
}