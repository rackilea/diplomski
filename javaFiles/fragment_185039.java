class PropProvider<T> implements Provider<Prop<T>> {
    private final Class<T> type;
    @Inject Client client;

    PropProvider(Class<T> type) {
        this.type = type;
    }

    @Override
    public void get() {
        return client.getProp(type);
    }
}

class MyModule extends AbstractModule {
    @override
    protected void configure() {
        bind(new TypeLiteral<Prop<User>>() { })
                .toProvider(new PropProvider(User.class));
        // More similar statments...
    }
}