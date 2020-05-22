private static final Object lockObject = new Object();
...
public void bow(Friend bower) {
    synchronized (lockObject) {
        ....
    }
}