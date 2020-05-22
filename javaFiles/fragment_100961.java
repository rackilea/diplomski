for( Person person : peopleToGet ) {
    List<Predicate> andPredicates = new ArrayList<>();

    if( person.getName() != null ) andPredicates.add(cb.equal(e.get("name"), person.getName()));
    if( /* similar code for the other properties */ ) /* ... */;

    predicates.add(cb.or(cb.and( andPredicates.toArray(new Predicate[andPredicates.size()]) )));
}