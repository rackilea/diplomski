enum MyEnum {
    STEP(Step.class),
    FOO(Foo.class),
    BAR(Bar.class);

    public final Class<?> klass;

    private MyEnum(Class<?> klass) {
        this.klass = klass;
    }
}