@Override
public Application configure() {
    ResourceConfig config = new ResourceConfig(...);
    config.register(new AbstractBinder(){
        @Override
        public void configure() {
            bindFactory(HttpServletRequestFactory.class).to(HttpServletRequest.class);
        }
    });
}