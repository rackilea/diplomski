EntityManager em;  // to be built or injected
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> cq = cb.createTupleQuery();
Root<Customer> customer = cq.from(Customer.class);
CollectionJoin<Customer, Order> orders = customer.join(Customer_.orders, JoinType.LEFT);
cq.select(cb.tuple(customer, cb.count(orders)));
cq.where(... add some predicates here ...);
cq.groupBy(customer.get(Customer_.id));
cq.orderBy(cb.desc(cb.count(orders)));
List<Tuple> result = em.createQuery(cq).getResultList();
for (Tuple t : result) {
    Customer c = (Customer) t.get(0);
    Long cnt = (Long) t.get(1);
    System.out.println("Customer " + c.getName() + " has " + cnt + " orders");
}