CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
Root<Customer> customer = q.from(Customer.class);
Subquery<Long> sq = q.subquery(Long.class);
Root<Customer> customerSub = sq.correlate(customer);
Join<Customer,Order> order = customerSub.join(Customer_.orders);
q.where(cb.gt(sq.select(cb.count(order)), 10))
.select(customer);