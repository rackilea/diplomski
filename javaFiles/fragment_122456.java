public class DbAccessClass {
    private final DataSource dataSource;

    public DbAccessClass(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public doSomething() {
        dataSource.getConnection();
        // use connection
    }
}