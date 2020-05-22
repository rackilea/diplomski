CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Tuple> criteriaQuery = cb.createQuery(Tuple.class);
Root<Membership> root = query.from(Membership.class);

Collection<Long> queredPrograms = levels.keySet()
Predicate[] queryPredicates = new Predicate[queredPrograms.size()];
int i = 0;
for(Long programId : queredPrograms) {
    queryPredicates[i++] = cb.and(
        cb.equal(root.get("programId"), programId),
        root.get("programLevel").in(levels.get(programId))
    );
}
criteriaQuery.where(
    cb.and(
        cb.or(queryPredicates),
        root.get("programId").in(queredPrograms)
    )
);

criteriaQuery.groupBy(root.get("programId"));
criteriaQuery.select(cb.tuple(cb.count(cb.distinct(root.get("memberId"))), root.get("programId")));
TypedQuery<Tuple> countSelection = entityManager.createQuery(criteriaQuery);