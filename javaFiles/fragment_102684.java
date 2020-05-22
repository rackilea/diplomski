public MyModule extends AbstractModule {
    @Override
    public void configure() {
        bind(RestTemplate.class);
    }
}