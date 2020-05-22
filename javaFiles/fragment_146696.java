final AtomicBoolean once = new AtomicBoolean(true);
Runnable r = new Runnable() {
    @Override public void run() {
        if (once.getAndSet(false))
           doSomething();
    }
}