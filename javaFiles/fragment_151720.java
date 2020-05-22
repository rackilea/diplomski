public abstract class Parent{
    Object parentObj;

    public final Object something() {
        parentObj = ...;
        return doSomething();
    }

    protected abstract Object doSomething();

}