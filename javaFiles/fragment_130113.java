@Bean
public Foo2 foo2() {
    return new Foo2(foo1("test"));
}

@Bean
public Foo2 bar2() {
    return new Foo2(foo1("test bar2"));
}

public Foo1 foo1(final String name) {
    return new Foo1(name);
}