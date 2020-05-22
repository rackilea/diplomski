public abstract class GeneralDao<T> {

    @PersistenceContext(unitName = "Persistence")
    EntityManager em;

    private List<T> allT;

    public List<T> getAllT(){

        TypedQuery<T> typedQuery = em.createQuery("Select t from " + getClassType().getSimpleName() + " t", getClassType());

    }

    protected abstract Class<T> getClassType();
}