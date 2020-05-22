private final Object lock = new Object();
    private volatile boolean isServiceInitialized;
    private volatile ApplicationContext context; 

    public Object getBean(String beanName) {
        if (!isServiceInitialized || context == null) {
            synchronized(lock) {
                if (!isServiceInitialized || context == null) {
                    initializeTouchPointService();
                    isServiceInitialized = true;
               }
            }
        }
        return CONTEXT.getBean(beanName);
    }