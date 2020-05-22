private Runnable target;

public void run() {
    if (target != null) {
        target.run();
    }
}