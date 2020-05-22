final void initDispatchThread() {
    pushPopLock.lock();
    try {
        if (dispatchThread == null && !threadGroup.isDestroyed() && !appContext.isDisposed()) {
            dispatchThread = AccessController.doPrivileged(
                new PrivilegedAction<EventDispatchThread>() {
                    public EventDispatchThread run() {
                        EventDispatchThread t =
                            new EventDispatchThread(threadGroup,
                                                    name,
                                                    EventQueue.this);
                        t.setContextClassLoader(classLoader);
                        t.setPriority(Thread.NORM_PRIORITY + 1);
                        t.setDaemon(false);
                        AWTAutoShutdown.getInstance().notifyThreadBusy(t);
                        return t;
                    }
                }
            );
            dispatchThread.start();
        }
    } finally {
        pushPopLock.unlock();
    }
}