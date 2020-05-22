EntityManager em = emf.createEntityManager(); // or injected

CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Party> query = cb.createQuery(Party.class);
Root<Party> partyRoot = query.from(Party.class);
query.select(partyRoot);

Predicate predicate = null;
Path<Date> startDatePath = partyRoot.<Date>get("startDate");
if (startDate != null) {
    predicate = cb.greaterThanOrEqualTo(startDatePath, startDate);
}
if (endDate != null) {
    Predicate additionalPredicate = cb.lessThanOrEqualTo(partyRoot.<Date>get("endDate"), startDate);
    if (predicate == null) {
        predicate = additionalPredicate;
    } else {
        predicate = cb.and(predicate, additionalPredicate);
    }
}
query.where(predicate);

if (sortBy == null || !sortBy.equals("distance")) {
    query.orderBy(cb.asc(startDatePath));
}

return em.createQuery(query).setMaxResults(count).getResultList();