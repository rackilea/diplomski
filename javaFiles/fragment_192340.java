public abstract class MiddleClass extends BaseClass {

    // {BaseClass} Overrides
    public void doStuff() {
        performMiddleTasks();
        doProxyExec();
        super.doStuff();
    }

    public abstract void doProxyExec();
}