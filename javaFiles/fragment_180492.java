CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> q = qb.createQuery(Long.class);
Root<Person> root = q.from(Person.class);
Path<String> email = root.get("email");
Path<String> password = root.get("password");

cq.select(cb.count(root)).where(
    cb.and(
        cb.equal(email, emailInput),
        cb.equal(password, passwordInput)
    )
);

return entityManager.createQuery(cq).getSingleResult();