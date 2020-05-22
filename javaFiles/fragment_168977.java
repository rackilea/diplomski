public class B {

    private final A a;

    public B(A a) {
        this.a = a;
        c = new C(a);
    }
    private final C c;
}