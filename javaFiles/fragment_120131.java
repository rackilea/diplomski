public class MyMyBatisModule extends PrivateModule {

    private final String     datasourceLabel;
    private final Properies  datasourceProperties;
    private       List< Key<?> > exposedKeys = new ArrayList< Key<?> >();

    public MyMyBatisModule( String datasourceLabel, Properties datasourceProperties ) {

        this.datasourceLabel = datasourceLabel;
        this.datasourceProperties = datasourceProperties;
    }

    @Override
    protected void configure() {

        install( new InternalMyMyBatisModule( ) );

        for( Key<?> key: keys ) {
            expose( key );
        }
    }

    private class InternalMyMyBatisModule extends MyBatisModule {

        @Override
        protected void initialize( ) {

            environmentId( datasourceLabel );
            Names.bindProperties( binder(), properties );

            install( JdbcHelper.MySQL ); // See JDBC Helper commentary below

            bindDataSourceProviderType( C3p0DataSourceProvider.class ); // Choose whichever one you want
            bindTransactionFactoryType( JdbcTransactionFactory.class );

            // Register your mapper classes here.  These mapper classes will have their
            // keys exposed from the PrivateModule
            //
            // i.e.
            // 
            // keys.add( registerMapper( FredMapper.class );
            // kets.add( registerMapper( GingerMapper.class );
        }

        private <T> Key<T> registerMapper( Class<T> mapperClass ) {
            Key<T> key = Key.get( mapperClass, Names.named( datasourceLabel ) );
            bind( key ).to( mapperClass );
            addMapperClass( mapperClass );
            return key;
        }
    }
}