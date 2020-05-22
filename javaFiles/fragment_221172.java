@Component
@Service
public class SQLHelper {

    @Reference // This is a connection pool DataSource
    private DataSource dataSource;

    public <R> R execute(Callback<R> callback) {
        try (Connection c = dataSource.getConnection()) {
            return callback.call(c);
        } catch (SQLException e) {
            throw new UncheckedSQLException(e);
        }
    }
}