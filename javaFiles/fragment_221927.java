final EntityManager em = this.entityManager();
final CriteriaBuilder builder = em.getCriteriaBuilder();
final CriteriaQuery < Dataset > criteriaQuery = builder.createQuery(Dataset.class);
final Root < Dataset > resultSetRoot = criteriaQuery.from(Dataset.class);
final SetJoin < Dataset, Report > join = resultSetRoot.join(Dataset_.reports);

criteriaQuery.select(builder.count(resultSetRoot)).where(builder.equal(join.get(Report_.id), reportId));

Long count = em.createQuery(criteria).getSingleResult();