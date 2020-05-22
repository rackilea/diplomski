static class MonitorRunnable implements Runnable {

    static final List<Runnable> activeTasks = Collections.synchronizedList(new ArrayList<>());

    private final Runnable runnable;

    public MonitorRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        activeTasks.add(runnable);
        runnable.run();
        activeTasks.remove(runnable);
    }
}