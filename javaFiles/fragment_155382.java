ClassLoader old = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(this);

    try {
    ---------
    } finally {
        Thread.currentThread().setContextClassLoader(old);
    }