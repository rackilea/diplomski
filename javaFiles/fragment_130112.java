@Bean
public Foo2 bar2(@Qualifier("bar1") Foo1 bar1) {
    return new Foo2(bar1);
}

@Bean
public Foo2 foo2(@Qualifier("foo1") Foo1 foo1) {
    return new Foo2(foo1);
}

@Bean
public Foo1 foo1(@Value("test foo1") final String name) {
    return new Foo1(name);
}

@Bean
public Foo1 bar1(@Value("test bar1")  final String name) {
    return new Foo1(name);
}