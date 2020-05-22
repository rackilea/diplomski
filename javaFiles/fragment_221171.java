@Component
public class MyComponent {

    // Connection pool based DataSource
    @Reference
    DataSource dataSource;

    public void myFunction() {
        try (Connection c = dataSource.getConnection()) {
            // Database operations
        } catch (SQLException e) {
            // TODO
        }
    }
}