public class A {
    private volatile V v;

    public V getV() {
        return v;
    }

    public V updateV(A a, B b, Cc) {
        //complex logic updating V
        this.v = new V(...);
        return v;
    }
}