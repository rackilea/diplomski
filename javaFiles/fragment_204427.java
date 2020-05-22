public class DaoModule<T> extends PrivateModule {

    private static final String ENVIRONMENT_ID = "development";

    private final Key<T> key;
    private final Class<T> mapper;
    private final Provider<DataSource> dataSourceProvider;

    public DaoModule(Key<T> key, Class<T> mapper, Provider<DataSource> dataSourceProvider) {
        this.key = key;
        this.mapper = mapper;
        this.dataSourceProvider = dataSourceProvider;
    }

    @Override
    protected void configure() {
        install(new InnerMyBatisModule());
        expose(key);
    }

    private class InnerMyBatisModule extends MyBatisModule {
        @Override
        protected void initialize() {
            bind(key).to(mapper);
            addMapperClass(mapper);

            environmentId(ENVIRONMENT_ID);
            bindDataSourceProvider(dataSourceProvider);
            bindTransactionFactoryType(JdbcTransactionFactory.class);
        }
    }
}