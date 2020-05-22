public class Base {
    private int counter;

    private void increment() {
        counter++;
    }
    protected int getNewCounter() {
        increment();
        return counter;
    }
}

public class A extends Base {
    public int aMethod() {
        return getNewCounter();
    }
}

public class B extends Base {
    public int anotherMethod() {
        return getNewCounter();
    }
}