List<Predicate> predicates = new ArrayList<Predicate>();

if ( <some condition> ) {
    predicates.add(criteriaBuilder.like(<your query condition>));
} else {
    predicates.add(criteriaBuilder.equal(<your query condition>));
}