@Service
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    // this is pretty much the same as the above SourceSessionFactory
    // but with a map of CustomDataSources instead of
    // AnnotationSessionFactoryBeans
    @Autowired
    private DynamicDataSourceFactory dataSourceFactory;

    // This is the sticky part. I currently have a workaround instead.
    // Hibernate needs an actual connection upon spring startup & there's
    // also no session in place during spring initialization. TBC.
    // @Resource(name = "UserContext") // scope session, proxy bean
    private UserContext userCtx; // something that returns the DB config

    @Override
    protected SourceId determineCurrentLookupKey() {
        return userCtx.getSourceId();
    }

    @Override
    protected CustomDataSource determineTargetDataSource() {
        SourceId id = determineCurrentLookupKey();
        return dataSourceFactory.getDataSource(id);
    }

    @Override
    public void afterPropertiesSet() {
        // we don't need to resolve any data sources
    }

    // Inherited methods copied here to show what's going on

//  @Override
//  public Connection getConnection() throws SQLException {
//     return determineTargetDataSource().getConnection();
//  }
//
//  @Override
//  public Connection getConnection(String username, String password)
//          throws SQLException {
//      return determineTargetDataSource().getConnection(username, password);
//  }
}