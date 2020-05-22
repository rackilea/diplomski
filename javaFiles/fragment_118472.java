CompletableFuture<Void> myFuture = new CompletableFuture<>();
Thread mainThread = Thread.currentThread();
CompletableFuture.runAsync(() -> {
    try {
        Thread.sleep(1000);
        System.out.println("Interrupting…");
        mainThread.interrupt();
        Thread.sleep(1000);
        System.out.println("Completing");
        myFuture.complete(null);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});
try {
    myFuture.get();
    System.out.println("Get succeeded");
} catch (Exception e) {
    System.out.println("Get failed");
    e.printStackTrace();
}