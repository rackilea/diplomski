public boolean cancel(boolean mayInterruptIfRunning) {
    return setCompletion(CANCELLED) == CANCELLED;
}

private int setCompletion(int completion) {
    for (int s;;) {
        if ((s = status) < 0)
            return s;
        if (UNSAFE.compareAndSwapInt(this, statusOffset, s, completion)) {
            if (s != 0)
                synchronized (this) { notifyAll(); }
            return completion;
        }
    }
}