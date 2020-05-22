public static FooBar createWithFooOnly(String foo) {
    FooBar fb = new FooBar();
    fb.setFoo(foo);
    return fb;
}

public static FooBar createWithBarOnly(String bar) {
    FooBar fb = new FooBar();
    fb.setBar(bar);
    return fb;
}

public static FooBar createWithFooAndBar(String foo, String Bar) {
    FooBar fb = new FooBar();
    fb.setFoo(foo);
    fb.setBar(bar);
    return fb;
}