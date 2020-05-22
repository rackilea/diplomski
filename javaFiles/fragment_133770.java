@Stateless
public class FooService {

    @PersistenceContext
    private EntityManager em;

    public Foo find(Long id) {
        return em.find(Foo.class, id);
    }

    // ...
}