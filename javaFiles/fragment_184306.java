ResourceConfig config = new ResourceConfig(PricingResource.class);
config.register(new AbstractBinder() {
    @Override
    protected void configure() {
        bind(pricingServiceMock).to(PricingService.class);
    }
});