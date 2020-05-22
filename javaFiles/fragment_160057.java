private boolean isDone = false;

public void code() {
    a();
    synchronized (this) {
        if (!isDone) {
            b();
            isDone = true;
        }
    }
    c();
}