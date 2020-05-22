System.out.println("Started");
Thread thread = new Thread(() -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Finished");
});
thread.start();

try {
    thread.join();
} catch (InterruptedException e) {
    e.printStackTrace();
}
System.out.println("Done");