public static final class Getters<T> {
    public static final Getters<String> FOO = new Getters<>(MyPoJo::getFoo);
    public static final Getters<String> BAR = new Getters<>(MyPoJo::getBar);
    public static final Getters<Integer> BAZ = new Getters<>(MyPoJo::getBaz);

    private final Function<MyPoJo, T> fn;

    private Getters(Function<MyPoJo, T> fn) {
        this.fn = fn;
    }

    public T getValue(MyPoJo object) {
        return fn.apply(object);
    }
}