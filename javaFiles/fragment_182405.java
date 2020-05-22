public void takeoff() {
    try {
        Thread.currentThread().sleep(1000);
    } catch (InterruptedException e) {
        // squash ...
    }
    System.out.println(Thread.currentThread().getName() + " took off");
    synchronize (this) {
        isFull = false;
        notifyAll();
    }
}