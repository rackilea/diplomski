public enum Factory<T> {
    F_A(A.class),
    F_B(B.class);

    private static final Set<Class<T>> klasses = new HashSet<>();
    static {
        for (Factory f : values()) {
            klasses.add(f.klass);
        }
    }

    public final Class<T> klass;

    private Factory(Class<T> klass) {
        this.klass = klass;
    }

    //public <S extends T> S instantiate(Class<S> kl) {
    public T instantiate() {
        ...
    }
}