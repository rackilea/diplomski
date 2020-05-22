public static Singleton getInstance() {
    // new "singleton" for every method call
    Singleton s = new Singleton();
                   ^^^^^^^^^^^^^^
    if (instance.compareAndSet(null, s)) {
        synchronized (s) {
            s.init();
        }
    }
    return instance.get();
}