private Predicate searchBySportsPredicate(Root<PlaygroundEntity> root, CriteriaBuilder cb) {
    List<Predicate> predicates = new ArrayList<>(sportCodes.size());
    Path<String> codePath = root.join(PlaygroundEntity_.specializations).get(SportEntity_.code)
    for (String sportCode : sportCodes) {
        predicates.add(cb.equal(codePath, sportCode));
    }
    return cb.and(predicates.toArray(new Predicate[0]));
}