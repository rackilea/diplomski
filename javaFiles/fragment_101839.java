CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> cq = cb.createTupleQuery(); // or createQuery(Tuple.class)
Root<Output> root= cq.from(Output.class); // from clause
CollectionJoin<Output, Interval> join = root.join(Output_.intervals);
Path<String> addressPath = root.get(Output_.address); // mind these Path objects
Path<Calendar> startPath = join.get(Interval_.start); // these are the key to success!
cq.multiselect(addressPath, startPath); // select clause
Expression<Calendar> start = join.get(Interval_.start);
Predicate pred = cb.greaterThanOrEqualTo(start, /* calendar for '2011-04-30' */);
cq.where(pred); // where clause
TypedQuery<Tuple> tq = em.createQuery(cq); // holds Tuples
for (Tuple tuple : tq.getResultsList()) {
    String address = tuple.get(addressPath);
    Calendar start = tuple.get(startPath);
...