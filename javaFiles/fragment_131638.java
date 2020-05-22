@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class RWTransactionDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public void createOrderTxns(RWRetailTransaction peTxn, RWRetailTransaction fcTxn) {
        create(peTxn);
        create(fcTxn);
        log.debug("Committed Transaction : {} ", peTxn.displayString());
        log.debug("Committed Transaction : {} ", fcTxn.displayString());
    }

    @Transactional
    public void create(T entity) {
        getEntityManager().persist(entity);
    }