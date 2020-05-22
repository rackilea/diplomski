public class MyRestService {
    private DataStoreService dataStoreService;

    // constructor used on the server
    public MyRestService() {
        this.dataStoreService = DatastoreServiceFactory.getDatastoreService();
    }

    // constructor used by the unit tests
    public MyRestService(DataStoreService dataStoreService) {
        this.dataStoreService = dataStoreService;
    }

    public Response initialize(String DatabaseSchema) {
         ...
         // use this.dataStoreService instead of datastore
    }
}