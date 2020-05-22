final BlockingQueue<Runnable> queue = ...

Runnable runs = new Runnable() { public void run() {
    while(running)
        queue.take().run();
}};