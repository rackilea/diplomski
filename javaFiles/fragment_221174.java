@Component
@Service
public class MiniCPMDataSourceComponent implements DataSource {

    @Reference
    protected ConnectionPoolDataSource cpDataSource;

    private MiniConnectionPoolManager wrapped;

    @Activate
    public void activate() {
        this.wrapped = new MiniConnectionPoolManager(cpDataSource);
    }

    @Override
    public Connection getConnection() {
        return wrapped.getConnection();
    }

    @Override
    public Connection getConnection(String user, String password) {
        throw new UnsupportedOperationException();
    }

    @Deactivate
    public void deactivate() {
        wrapped.dispose();
    }
}