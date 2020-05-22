@Repository
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    protected final Class<T> ENTITY_CLASS;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected MappingManager manager;

    protected Mapper<T> mapper;

    public BaseDAOImpl() {
        // get type of <T> hack...
        this.ENTITY_CLASS = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PostConstruct
    public void init(){
        mapper = manager.mapper(ENTITY_CLASS);
    }

    [...]
}