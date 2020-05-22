public class MyBatisModules extends AbstractModule {

    private Map< String, Properties > connectionsProperties;

    public MyBatisModules( Map< String, Properties > = new HashMap< String, Properties > connectionsProperties ) {
        this.connectionsProperties = connectionsProperties; // consider deep copy if appropriate
    }

    @Override
    protected void configure( ) {

        for( Entry< String, Properties > datasourceConnectionProperties : this.connectionsProperties.entrySet() ) {
            install( new MyMyBatisModule( datasourceConnectionProperties.getKey(), datasourceConnectionProperties.getValue() ) );
        }

        bind( MapperRetriever.class ); // See MapperRetriever later

        // bind your DAO classes here.  By wrapping MyBatis Mapper use in DAO implementations, theoretically we
        // can fairly easily change from MyBatis to any other database library just by changing the DAO implementation.
        // The rest of our codebase would remain the same.
        //
        // i.e.
        //
        // bind( FredDao.class ).to( FredDaoMyBatis.class );
        // bind( GingerDao.class).to( GingerDaoMyBatis.class );
    }
}