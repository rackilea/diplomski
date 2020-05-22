@Bean
public Foo2 foo2(Foo1 foo1) {
    return new Foo2(foo1);
}

@Bean
public Foo1 foo1(@Value("${name.property:test}") final String name) {
    return new Foo1(name);
}