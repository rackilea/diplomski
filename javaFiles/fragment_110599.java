public aspect SynchronizingAspect {
    private static final Object lock = new Object();

    pointcut syncJointPoint(): execution(@Synchronizes * *.*(..)); // or call()

    Object around(): syncJointPoint() {
        synchronized(lock) {
            return proceed();
        }
    }
}