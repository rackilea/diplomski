class Task extends TimerTask {
    Runnable runnable;
    Task(Runnable runnable) {
        this.runnable = runnable;
    }
    @Override
    public void run() {
        runnable.run();
    }
}