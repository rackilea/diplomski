private final static class ProcessPriorityThreadFactory implements ThreadFactory {

    private final int threadPriority;

    public ProcessPriorityThreadFactory(int threadPriority) {
        this.threadPriority = threadPriority;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(threadPriority);
        return thread;
    }

}