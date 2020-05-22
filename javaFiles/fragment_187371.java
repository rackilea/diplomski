public static enum Getters {
    FOO(MyPoJo::getFoo), BAR(MyPoJo::getBar);

    private final Function<MyPoJo, String> fn;

    private Getters(Function<MyPoJo, String> fn) {
        this.fn = fn;
    }

    public String getValue(MyPoJo object) {
        return fn.apply(object);
    }
}