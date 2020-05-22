@Override
protected void finalize() throws Throwable {
    if(!safelyClosed) {
        final Thread t = Thread.currentThread();
        t.getUncaughtExceptionHandler().uncaughtException(t, leftUnclosed);
    }
}