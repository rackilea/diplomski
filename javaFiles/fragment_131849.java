@Service
public class DeactivationService {

    private static final Logger LOG = Logger.getLogger(DeactivationService.class);

    @Autowired  
    @Qualifier("SkuAmerDao")
    private SkuDAO amerdao; //Dependency Injection Amer

    @Autowired 
    @Qualifier("SkuEMEADao")
    private SkuDAO emeadao; //Dependency Injection EMEA

    // no constructor needed.
}

public abstract class BaseDao implements SkuDAO {

    private final JdbcTemplate jdbcTemplate;       

    protected BaseDao() {
        this.jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    protected abstract DataSource getDataSource();

    public List<Sku> find() {
        //some processing to find the sku, purposely left empty as it is a sample code
    }

    public void deactivate(List<Sku>) {
        //some processing to deactivate the sku, purposely left empty as it is a sample code
    }
}

@Repository("SkuAmerDao")
public class SkuAmerDAOImpl extends BaseDao {
    @Autowired 
    @Qualifier("AmericasDataSource")
    private DataSource datasource; //Dependency injection

    @Override
    protected DataSource getDatasource() {
        return dataSource;
    }
}

@Repository("SkuEMEADao")
public class SkuEMEADAOImpl extends BaseDao {
    @Autowired 
    @Qualifier("EMEADataSource")
    private DataSource datasource; //Dependency injection

    @Override
    protected DataSource getDatasource() {
        return dataSource;
    }
}