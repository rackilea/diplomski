private Predicate searchBySportsPredicate(Root<PlaygroundEntity> root, CriteriaBuilder cb) {
    Collection<Predicate> predicates = new ArrayList<>();
    for (String sportCode : sportCodes) {
        predicates.add(
                cb.equal(root.join(PlaygroundEntity_.specializations).get(SportEntity_.code), sportCode)
        );
    }
    return cb.and(predicates.toArray(new Predicate[0]));
}