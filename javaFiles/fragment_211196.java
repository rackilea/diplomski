public abstract class Worker {
    private Worker next;

    protected Worker(Worker next) {
        this.next = next;
    }

    public void process(Workpiece wp) {
        preProcess(wp);

        if (next != null)
            next.process(wp);

        postProcess(wp);
    }

    public abstract void preProcess(Workpiece wp);
    public abstract void postProcess(Workpiece wp);
}