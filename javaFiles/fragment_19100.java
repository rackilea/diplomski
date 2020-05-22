CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
Root<Person> root = criteriaQuery.from(Person.class);
root.fetch("drivingLicense", JoinType.INNER);
criteriaQuery.select(root);
List<Person> resultList = em.createQuery(criteriaQuery).getResultList();