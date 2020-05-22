class SimpleThreadFactory implements ThreadFactory {
    private Thread monitorThread;
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        if( r instanceof FileAlterationMonitor) {
            monitorThread = thread;
        }

        return thread;
    }

    public boolean isMonitorThreadAlive() {
        boolean isAlive = false;
        if(monitorThread != null) {
            isAlive = monitorThread.isAlive();
        }
        return isAlive;
    }
}