@Service
public class RefreshableDataSource implements DataSource {

    private AtomicReference<DataSource> target = new AtomicReference<DataSource>();

    @PostConstruct
    public void refresh() {
        target.set(createDsManuallyUsingSomeExternalConfigurationSource());
    }

    @Override
    public Connection getConnection() throws SQLException {
        return target.get().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return target.get().getConnection(username, password);
    }

    //Rest of DataSource methods

}