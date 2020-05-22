public long countByTextLike(Set<String> strings) {
    CriteriaBuilder builder = currentSession().getCriteriaBuilder();
    CriteriaQuery<Long> query = builder.createQuery(Long.class);
    Root<Example> root = query.from(Example.class);

    Predicate[] predicates = new Predicate[strings.size()];

    query.select(builder.count(root.get("id")));

    Predicate langPredicate = builder.equal(root.get("lang"), "EN");

    int cont = 0;
    for (String word : strings) {
        Predicate pred = builder.like(root.get("text"), "%" + word + "%");
        predicates[cont++] = pred;
    }

    Predicate orPredicate = builder.or(predicates);

    Predicate finalPredicate = builder.and(orPredicate, langPredicate);

    return manager.createQuery(query).where(finalPredicate).getSingleResult();

}