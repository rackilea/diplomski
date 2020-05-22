@Transactional
@Repository
public class BarRepoImpl extends GenericDAOImpl<Bar, Long> implements BarRepo {

    public BarRepoImpl() {
        super(Bar.class);
    }

    @Override
    public List<Bar> findAllBarWithText(String text) {
        CriteriaQuery<Bar> c = em.getCriteriaBuilder().createQuery(Bar.class);
        return em.createQuery(c).getResultList();
    }
}