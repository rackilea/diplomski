public class DatabaseClientFactory {
    private DatabaseClientFactory() {}

    private static class LazyHolder {
        private static final DatabaseClient INSTANCE = new DatabaseClient();
    }

    public static DatabaseClient getInstance() {
        return LazyHolder.INSTANCE;
    }
}