public void fileTransfer() {
    try {
        semaphore.acquire();
        System.out.println("Running transfer...");
        // Code that performs the transfer
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        semaphore.release();
        System.out.println("Thread released..");
    }
}