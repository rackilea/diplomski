@PersistenceContext
EntityManager entityManager;

@Override
public List<YourClass> findByLabelLike(List<String> labels) {
    String q = "SELECT id, label FROM TABLE10";

    for (String l : labels) {
       // Add where and ORs
    }

    Query query = entityManager.createNativeQuery(q, YourClass.class);
    int i = 0;
    for (String label : labels) {
          query.setParameter(++i, "%"+label+"%");
    }

    return query.getResultList();
}