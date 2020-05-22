public void run() {
    try {
        int id = 0;
        while (true) {
            Thread.sleep(4000);
            queue.put(new Bread(id++));
        }
    } catch (InterruptedException e) {
    }
}