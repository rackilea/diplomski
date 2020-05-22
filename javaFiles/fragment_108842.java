public static class G<X, Z extends Y<X>> {
    public G(Class<? extends X> c, Class<Z> s) {}
    public void m(X x) {}
    public static <T, S extends Y<T>> G<T, S> create(Class<? extends T> c) {
        Class<S> s = null; // find this via some reflection magic
        return new G<T, S>(c, s);
    }
    public static void main(String[] args) {
        Object o = ""; // irrelevant!
        create(o.getClass()).m(o);
    }
}