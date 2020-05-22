BlockingQueue queue = new ArrayBlockingQueue<>(10000);
while (true) {
    String tmp = new randomString();
    if (!queue.offer(tmp)) {
        // the limit was reached, item was not added
    }
}