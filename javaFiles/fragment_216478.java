public class MyClass extends ParentA {

    private final ParentB runnable;
    private final Thread runningThread;

    public MyClass(ParentB runnable) {
        this.runnable = runnable;
        this.runningThread = new Thread(this.runnable);
    }

    public void start() {
        this.runningThread.start();
    }

    public void interrupt() {
        this.runningThread.interrupt();
    }

    public boolean isAlive() {
        return this.runningThread.isAlive();
    }
}