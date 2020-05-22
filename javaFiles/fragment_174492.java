@Service
public class PlanesService {

    @PersistenceContext(unitName = "entityManagerFactory1")
    private EntityManager em1;

    @PersistenceContext(unitName = "entityManagerFactory2")
    private EntityManager em2;


    @Transactional("transactionManager1")
    public Plane savePlanes() {
        F14 f14 = new F14("F14","f14");
        F16 f16 = new F16("F16","f16");

        em1.persist(f14);
        em2.persist(f16);

        return f14;
    }
}