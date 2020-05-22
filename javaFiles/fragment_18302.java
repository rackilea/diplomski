public class DataServiceFatory implements Factory<DataService> {

    private DataService dataService;

    @Inject
    public DataServiceFactory(ServiceLocator locator) {
        // abbreviated for brevity
        EMF emf = locator.getService(EMF.class);
        if (emf != null) {
            dataService = new WithDbService(emf);
        } else {
            dataService = new WithoutDbService();
        }
    }

    @Override
    public DataService provider() { return dataService; }
}
[...]
bindFactory(DataServiceFactory.class).to(DataService.class).in(..);