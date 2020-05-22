@Transactional
@TransactionConfiguration(defaultRollback=true)
@ContextConfiguration(locations="classpath*:applicationContext-deutes-punts-logica-Test.xml")
//@Test(groups = { "logica" })
public class ServeiDeutesTest extends AbstractTransactionalTestNGSpringContextTests {

    private Collection collection;
    @Autowired
    private IVwGptVBasicDao vwGptVBasicDAO;
    @Autowired
    private DbTestPreparator preparadorDb;

public IVwGptVBasicDao getVwGptVBasicDAO() {
        return vwGptVBasicDAO;
    }

    public void setVwGptVBasicDAO(IVwGptVBasicDao vwGptVBasicDAO) {
        this.vwGptVBasicDAO = vwGptVBasicDAO;
    }

    public DbTestPreparator getPreparadorDb() {
        return preparadorDb;
    }

    public void setPreparadorDb(DbTestPreparator preparadorDb) {
        this.preparadorDb = preparadorDb;
    }