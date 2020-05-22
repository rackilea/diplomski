class MyConstant<T> {
    public static final MyConstant<Step> STEP = new MyConstant<>();
    public static final MyConstant<Foo> FOO = new MyConstant<>();
    public static final MyConstant<Bar> BAR = new MyConstant<>();

    private MyConstant() {}
}