abstract class X<T> {
    public abstract T yourMethod();
}
class X1 extends X<X1> {
    public X1 yourMethod() {
        return this;
    }
}
class X2 extends X<X2> {
    public X2 yourMethod() {
        return this;
    }
}