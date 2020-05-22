public interface FredDao {
    Fred selectFred( String datasourceLable, String fredId );
}    

public class FredDaoMyBatis implements FredDao {

    private MapperRetriever mapperRetriever;

    @Inject
    public FredDaoMyBatis( MapperRetriever mapperRetriever ) {
        this.mapperRetriever = mapperRetriever;
    }

    @Override
    public Fred selectFred( String datasourceLabel, String fredId ) {
        FredMapper fredMapper = this.mapperRetriever.getFredMapper( datasourceLabel );
        return fredMapper.getFred( fredId );
    }
}