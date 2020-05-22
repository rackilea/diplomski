private final List<Predicate> predicates = new ArrayList<Predicate>(3);
...
if(a) {
    predicates.add(cb.equal(...));
}
if(b) {
    predicates.add(cb.equal(...));
}
if(c) {
    predicates.add(cb.equal(...));
}
...
query.where(predicates.toArray(new Predicate[predicates.size()]));
...