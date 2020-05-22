private class DelayedTrigger extends Task<Void> {

    private final long delay;
    private Runnable onTriggered;

    public DelayedTrigger(long delay, Runnable onTriggered) {
        this.delay = delay;
        this.onTriggered = onTriggered;
    }

    @Override
    protected Void call() throws Exception {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void succeeded() {
        if (onTriggered != null) {
            onTriggered.run();
        }
    }