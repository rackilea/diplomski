@Component
public class Initializer {

    @PersistenceContext
    EntityManager em;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        em.persist(new MyEntity());
    }
}