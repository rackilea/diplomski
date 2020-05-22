public MyModule extends AbstractModule {
    @Override
    public void configure() {
    }

    @Provides
    public RestTemplate providesRestTemplate() {
        return new RestTemplate();
    }
}