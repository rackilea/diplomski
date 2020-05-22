public class DocumentServiceImpl implements DocumentService {

    //...

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void refreshEntity(Object entity) {
        em.refresh(entity);
    }