//...

Expression<?> exp = criteriaBuilder.countDistinct(entity.get("concated"));
criteriaQuery.select(exp);

TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
return query.getSingleResult();