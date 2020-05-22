public ApplicationResource() {
    ...
    register(new AbstractBinder(){
        @Override
        public void configure() {
            bind(pipeline).to(ServiceXYZ.class);
        }
    });
}