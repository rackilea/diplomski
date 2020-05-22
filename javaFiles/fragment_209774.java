class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(B.class).to(BImpl.class);
        bind(C.class).to(CImpl.class);

        try {
            bind(A.class).toConstructor(A.class.getConstructor(B.class, C.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}