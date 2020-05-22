@Repository
public class TstDao{

    private static Logger LOG = LoggerFactory.getLogger(TstDao.class);

    @Autowired
    @Qualifier(value="transactionManager2")
    private PlatformTransactionManager tm;
    private TransactionTemplate transactionTemplate;

    @PostConstruct
    public void init(){
        transactionTemplate = new TransactionTemplate(tm);
        LOG.debug("tm="+tm);
    }

    @Autowired
    @Qualifier(value="sessionFactory2")
    SessionFactory sessionFactory;

    public List<Obj_Test> getAllUsers(){
        return transactionTemplate.execute(new TransactionCallback<List<Obj_Test>>() {

            @Override
            public List<Obj_Test> doInTransaction(TransactionStatus status) {

                Criteria crit = sessionFactory.getCurrentSession().createCriteria(Obj_Test);
                return crit.list();

            }

        });
    }
}