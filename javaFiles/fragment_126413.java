public final class SupplierUtils {
    private SupplierUtils() {
    }

    public static <T> Supplier<T> wrap(Callable<T> callable) {
        return () -> {
            try {
                return callable.call();
            }
            catch (RuntimeException e) {
                throw e;
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

public class JdbcConnectionPool extends ObjectPool<Connection> {

    public JdbcConnectionPool(int maxConnections, String url) {
        super(SupplierUtils.wrap(() -> DriverManager.getConnection(url)), maxConnections);
    }
}