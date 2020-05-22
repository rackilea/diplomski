class MyConstant<T> {
    public static final MyConstant<Step> STEP = new MyConstant<>(Step.class);
    public static final MyConstant<Foo> FOO = new MyConstant<>(Foo.class);
    public static final MyConstant<Bar> BAR = new MyConstant<>(Bar.class);

    public final Class<T> klass;

    private MyConstant(Class<T> klass) {
        this.klass = klass;
    }
}