// passed into the constructor and set in the init() method
private Runnable target;
...
// called from native thread code after start() is called
public void run() {
    if (target != null) {
        target.run();
    }
}