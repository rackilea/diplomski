public class DbMapperProvider<T extends DbMapper> implements Provider<T> {
    // Use field or method injection
    @Inject
    private Provider<User> user;

    private final Class<T> type;

    public DbMapperProvider(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        String jdbc = user.get().getJdbc();

        DBI userSpecificDatabase = new DBI(jdbc, "user", "password");
        DbMapper dbMapper = userSpecificDatabase.onDemand(type);
        return dbMapper;
    }
}