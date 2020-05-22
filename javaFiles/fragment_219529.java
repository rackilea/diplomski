@PersistenceContext
protected EntityManager entityManager;

public List<TestCase> findAll() {
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<TestCase> cq = cb.createQuery(TestCase.class);
Root<TestCase> from = cq.from(TestCase.class);
CriteriaQuery<TestCase> all = cq.select(from);
TypedQuery<TestCase> allQuery = em.createQuery(all);
return allQuery.getResultList();
}