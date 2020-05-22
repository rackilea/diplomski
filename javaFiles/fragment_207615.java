public class A{
    private int elem;

    public A(int elem) {
        this.elem = elem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return elem == a.elem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elem);
    }
}