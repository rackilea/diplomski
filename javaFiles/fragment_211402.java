// adapt TCCL
    Thread thread = Thread.currentThread();
    ClassLoader loader = thread.getContextClassLoader();
    thread.setContextClassLoader(InitializationService.class.getClassLoader());
    try {
        InitializationService.initialize();
    } finally {
        // reset TCCL
        thread.setContextClassLoader(loader);
    }