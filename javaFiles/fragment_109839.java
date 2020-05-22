int counter = MAX_SIZE + 1;
while (!future.isDone()) {
    String s = QUEUE.poll();
    if (s != null) {
        System.out.println(s);
        counter--;
    }
    try {
        TimeUnit.MILLISECONDS.sleep(1);
    } catch (InterruptedException e) {}
}