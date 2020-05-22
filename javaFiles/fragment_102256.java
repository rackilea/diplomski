public class A<T extends B> {
    public void fun(T t) {
    }
}

public class B {
    A<B> a;

    public void event() {
        a.fun(this);
    }
}