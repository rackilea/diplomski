public class MyThread extends Thread {
    private volatile boolean active = true;

    public void run() {
        // this.active = true;
        while (isActive()) {
            // do nothing
        }
    }

    public void finish() {
        this.active = false;
    }
}