public abstract class A {
    public final A f(A a) {
        if (a.getClass() != this.getClass()) {
            throw new IllegalArgumentException();
        }
        A res = fImpl(a);
        if (res.getClass() != this.getClass()) {
            throw new InvalidOperationException();
        }
        return res;
    }
    protected abstract A fImpl(A a); // Implementing classes put functionality here
}