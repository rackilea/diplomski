@Repository
public class userDAO {

    @PersistenceContext
    private EntityManager em;

    public void insertUser(users user) {
        em.persist(user);
    }
}