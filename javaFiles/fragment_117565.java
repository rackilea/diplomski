@BeforeClass
    public static void setup() {
        env = new Environment( "test-env", Jackson.newObjectMapper(), null, new MetricRegistry(), null );
        dbi = new DBIFactory().build( env, getDataSourceFactory(), "test" );
        dbi.registerArgumentFactory(new JodaDateTimeArgumentFactory());
        dbi.registerMapper(new JodaDateTimeMapper(Optional.absent()));
    }

    static DataSourceFactory getDataSourceFactory()
    {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setDriverClass( "org.h2.Driver" );
        dataSourceFactory.setUrl( "jdbc:h2:mem:testDb" );
        dataSourceFactory.setUser( "sa" );
        dataSourceFactory.setPassword( "" );
        return dataSourceFactory;
    }

    public static DBI getDbi() {
        return dbi;
    }

    public static Environment getEnvironment() {
        return env;
    }