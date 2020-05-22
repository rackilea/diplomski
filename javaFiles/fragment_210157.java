class CustomAdapterFactory extends DefaultDbAdapterFactory {
    public CustomAdapterFactory(
       @Inject("cayenne.server.adapter_detectors") 
       List<DbAdapterDetector> detectors) {
        super(detectors);
    }

    @Override
    public DbAdapter createAdapter(
        DataNodeDescriptor nodeDescriptor, 
        DataSource dataSource) throws Exception {

        AutoAdapter adapter = 
           (AutoAdapter) super.createAdapter(nodeDescriptor, dataSource);

        // your PkGenerator goes here
        adapter.setPkGenerator(...);
        return adapter;
    }
}

// add this when creating ServerRuntime
Module module = new Module() {
        @Override
        public void configure(Binder binder) {

            binder.bind(DbAdapterFactory.class).to(CustomAdapterFactory.class);
        }
    };