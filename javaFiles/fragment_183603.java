public abstract class AbstractA implements A {
    protected abstract void doStuff(X x);
    protected abstract void doMoreStuff(X x, Y y);

    public void execute() {
        X x = getX();
        doStuff(x);
        Y y = getY();
        doMoreStuff(x, y);
    }

    // getX(), getY(), etc...
}