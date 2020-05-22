public class A {
}

public class B extends A implements Cloneable {

    @Override
    public B clone() throws CloneNotSupportedException {
        return (B) super.clone();
    }
}