class A {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public double computeOne {
        synchronized(lock1) {
            ****
        }
    }

    public double computeTwo {
        synchronized(lock2) {
            ****
        }
    } 
}