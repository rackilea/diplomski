public class MapperRetriever {

    private final Injector injector;

    @Inject
    public MapperRetriver( Injector injector ) {
        this.injector = injector;
    }

    // The follwing two methods use the example Mappers referenced in the MyMyBatisModule implementation above

    public FredMapper getFredMapper( String datasourceLabel ) {
        return this.injector.getInstance( Key.get( FredMapper.class, Names.named( datasourceLabel ) ) );
    }

    public GingerMapper getGingerMapper( String datasourceLabel ) {
        return this.injector.getInstance( Key.get( GingerMapper.class, Names.named( datasourceLabel ) ) );
    }
}