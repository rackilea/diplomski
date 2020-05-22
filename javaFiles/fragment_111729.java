public class A {
    private V v;

    public synchronized V getV() {
        return v;
    }

    public synchronized V updateV(A a, B b, Cc) {
        //complex logic updating V
        this.v = new V(...);
        return v;
    }
}