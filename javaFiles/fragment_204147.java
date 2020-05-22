@Repository("GroupDAO")
public class GroupDAO {
    @PersistenceContext
    protected EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Group group) {
        try {
            em.persist(group);
            em.flush();
        } catch (PersistenceException pe) {
        }
    }
}