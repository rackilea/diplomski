public class B {
    @Subscribe
    public void f(E e) {
        System.out.println("IN B");
    }
}

public class D extends B {
    @Subscribe
    public void f(E e) {
        System.out.println("IN D");
    }
}