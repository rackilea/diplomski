private AtomicBoolean isDone = new AtomicBoolean(false);

 public void code() {
    a();
    if (isDone.compareAndSet(false, true)) {
       b();
    }
    c();
}