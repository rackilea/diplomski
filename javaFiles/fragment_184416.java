public class A {
    private int x;
    public void setX(int x) { this.x = x; }
    public int getX() { return this.x; }
}

public class B {
    public B(A a) {
        // copy all A properties from the object that we're going to extend
        this.setX(a.getX());
    }

    .. other stuff
}