@Stateless
public class DatabaseUpdater {

    @Resource
    private Datasource dataSource;

    // OR

    @PersistenceContext
    private EntityManager em;

    @javax.ejb.Asynchronous
    public void updateDatabase() {
        // beware of long running transaction timeouts in here!
        ...
    }

}