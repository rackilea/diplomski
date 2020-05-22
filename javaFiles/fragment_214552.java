public class MyClass {
    private Thread thread;
    public void start() {
       thread = new Thread(this::doWork); // Java 8 method reference
       thread.start();
    }
    private void doWork() {
        // ...
    }
}