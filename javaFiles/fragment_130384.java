public class TaskEx extends Task<Void> {
    private final Runnable[] logics;

    public TaskEx(Runnable[] logics) {
        this.logics = logics;
    }

    @Override
    protected Void call() {
        for (int i = 0; i < logics.length; i++) {
            logics[i].run();
            updateProgress(i, logics.length);
        }
    }
}