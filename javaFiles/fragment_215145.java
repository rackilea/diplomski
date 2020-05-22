synchronized (b) {
    try {
        System.out.println("Waiting for b to complete...");
        while (b.total == 0) {
            b.wait();
        }
    } catch (InterruptedException e) {
    }
    System.out.println("Total is: " + b.total);
}