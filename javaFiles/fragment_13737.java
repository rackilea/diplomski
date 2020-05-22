// These are initializations
String username = ... // the criterion
EntityManager em = ...
CriteriaBuilder cb = em.getCriteriaBuilder();
// Next line means "the result of the query is Person"
CriteriaQuery<Person> query = cb.createQuery(Person.class);
// This matches the "FROM Person p" part of the JPQL
Root<Person> root = query.from(Person.class);
// This matches the "JOIN User u" part of the JPQL
Join<Person, User> joinUser = root.join("user"); // if you have created the metamodel, adjust accordingly
// This is the "WHERE..." part
query.where(cb.like(cb.lower(joinUser.get("name")), "%" + username.toLowerCase() + "%"));