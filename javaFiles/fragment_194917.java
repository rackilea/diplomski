@Stateless
public class ECMSEntityManagerDao implements ECMSEntityManagerDaoLocal, ECMSEntityManagerDaoRemote {

    @PersistenceContext(unitName = "mracPU")
    EntityManager em;
}