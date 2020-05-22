class X {
    private static final Object lock = new Object();
    public void oneAtATime() {
        synchronized (lock) {
            // Do stuff
        }
    }
}
class Y {
    public void oneAtATime() {
        synchronized (Y.class) {
            // Do stuff
        }
    }
}