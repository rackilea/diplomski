@Autowired
EntityManager entityManager;

@Override
public PharmacyEntity save(PharmacyEntity entity) {


    entityManager.persist(entity);
    return entity;
}