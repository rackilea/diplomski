System.out.println("Started");
final Object monitor = new Object();
Thread thread = new Thread(() -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Finished");
    synchronized (monitor) {
        monitor.notify();  // Notify the main thread
    }
    synchronized (Test.class) {
        try {
            Test.class.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
thread.start();

synchronized (monitor) {
    try {
        monitor.wait();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
System.out.println("Done");