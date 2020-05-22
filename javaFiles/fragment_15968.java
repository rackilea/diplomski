ResourceConfig config = new ResourceConfig();
config.register(new AbstractBinder() {
    @Override
    protected void configure() {
        bind(MyInterceptionService.class)
                .to(InterceptionService.class)
                .in(Singleton.class);
    }
});