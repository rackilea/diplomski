public class Foo {
    @Value("Hello, world!")
    public String value;
}

@Configuration
public class Config {
    @Bean
    public Foo createFoo() {
        Foo foo = new Foo();
        System.out.println(foo.value); // Prints null - foo not initialized yet
        return foo;
    }

    @Bean
    public Bar createBar() {
        Foo foo = createFoo();
        System.out.println(foo.value); // Prints Hello, world! - foo have been initialized by the interceptor
        return new Bar(foo);
    }
}