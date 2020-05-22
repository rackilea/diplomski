public class A {

    private int a;

    @Override
    public A clone() throws CloneNotSupportedException {
        A newA = (A) super.clone();
        newA.a = a;
        return newA;
    }
}

public class B extends A implements Cloneable {

    private int b;

    @Override
    public B clone() throws CloneNotSupportedException {
        B newB = (B) super.clone();
        newB.b = b;
        return newB;
    }
}