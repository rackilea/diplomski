class Test<T> {
    private final Class<T> cl;
    List<T> l = new ArrayList<>();

    public Test(Class<T> c) {
        cl = c;
    }

    public void add(Object o) {
        l.add(cl.cast(o));
    }
}