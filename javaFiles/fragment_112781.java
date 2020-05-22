public class Bar {
    private Foo foo;

    @Autowired
    public Bar(Foo foo) {
        this.foo = foo;
        foo.func();
    }
}