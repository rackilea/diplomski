EntityManager em = ...
QueryBuilder qb = em.getQueryBuilder();
CriteriaQuery<Person> c = qb.createQuery(Person.class);
Root<Person> p = c.from(Person.class);
Predicate condition = qb.gt(p.get(Person_.age), 20);
c.where(condition);
TypedQuery<Person> q = em.createQuery(c); 
List<Person> result = q.getResultList();