class MyPool extends ThreadPoolExecutor {
    private volatile Thread activeThread = null;
    private static final Field FutureTask$runner;

    static {
        try {
            FutureTask$runner = FutureTask.class.getDeclaredField("runner");
            FutureTask$runner.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    private static Thread getThread(FutureTask<?> task) {
        try {
            return (Thread) FutureTask$runner.get(task);
        } catch (IllegalAccessException e) {
            throw new Error(e);
        }
    }

    public MyPool() {
        super(1, 1,
            //whatever here
            5000, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if(activeThread != null) {
            activeThread.stop(); //kill
        }
        FutureTask<T> activeTask = (FutureTask<T>)super.submit(task);
        activeThread = getThread(activeTask); //steal thread reference for killing
        return activeTask;
    }
}