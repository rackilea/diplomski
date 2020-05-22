class Foo {
    private static int bar = 0;
    public static synchronized void inc() { bar++; }
    public synchronized int get() { 
        synchronized (Foo.class) { // Synchronizes with static synchronized methods
            return bar; 
        }
    }
}