public static class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<A<Integer>>() {}).toInstance(new B());
    }
}