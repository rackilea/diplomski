public void run() {
    try {
        System.out.println(Thread.currentThread().getName() + exchanger.exchange("this came from subthread"));
        exchanger.exchange("allow JVM to exit here");
    } catch (InterruptedException ex) {
        System.out.println("interrupted while waiting for message");
    }
}