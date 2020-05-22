public class SomeService {

    private SomeDao someDao;

    /**
     * Constructor used in production. Creates or looks up its own DAO
     */
    public SomeService() {
        this.someDao = new SomeDao();
    }

    /**
     * Constructor used by unit tests, which can pass a mock DAO instance.
     */
    public SomeService(SomeDao someDao) {
        this.someDao = someDao;
    }

    ...
}