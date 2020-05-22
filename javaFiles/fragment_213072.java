CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
Root<MyEntity> from = criteriaQuery.from(classType);

criteriaQuery.multiselect(
    from.get("date").as(java.sql.Date.class),
    criteriaBuilder.count(from)
);

/*Add order by and group by clause*/
criteriaQuery.orderBy(criteriaBuilder.desc(from.get("date").as(java.sql.Date.class)));
criteriaQuery.groupBy(from.get("date").as(java.sql.Date.class));

TypedQuery<Object[]> query = em.createQuery(criteriaQuery);
List<Object[]> results = query.getResultList();