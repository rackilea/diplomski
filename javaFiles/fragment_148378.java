public void run() {
    while (true) {
        Runnable task = queue.take();
        task.run();
    }
}