private static class InterruptTimerTask extends TimerTask {
    private Thread thread;

    public InterruptTimerTask(Thread thread) {
        this.thread=thread;
    }

    @Override
    public void run() {
        thread.interrupt();
    }

}