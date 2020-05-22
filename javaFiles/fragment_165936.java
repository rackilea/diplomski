public static class RefCountJob extends Job {
    public RefCountJob() {
        super("REF_COUNT");
    }

    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        monitor.beginTask("WAITING", IProgressMonitor.UNKNOWN);
        while (count > 0) {
            Thread.sleep(200);
            monitor.worked(1);
        }
        monitor.done();
        return Status.OK_STATUS;
    }
}