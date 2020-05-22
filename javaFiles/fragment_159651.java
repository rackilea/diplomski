private static class FooHolder {
    private static final Foo INSTANCE = new Foo();
}

public static Foo getInstance(){
    return FooHolder.INSTANCE;
}