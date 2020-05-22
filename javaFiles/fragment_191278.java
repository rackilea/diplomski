public class Base {
    public final void execute() {
        doExecute();
        someMethod();
    }

    protected abstract void doExecute();

    public void someMethod() {
    }
}