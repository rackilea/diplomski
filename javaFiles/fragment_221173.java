@Component
@Service
public class MyComponent {

    @Reference
    private DataSource dataSource;

    @Reference
    private TransactionHelper th;

    public void myFunction() {
        th.required(() -> {
            try (Connection c = dataSource.getConnection()) {
                // My SQL statements
            } catch (SQLException e) {
                // TODO
            }
        }
    }
 }