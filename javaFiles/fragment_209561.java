CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
Root user = criteriaQuery.from(User.class);
criteriaQuery.where(criteriaBuilder.equal(user.get("id"), criteriaBuilder.parameter(Long.class, "id")));
Query query = entityManager.createQuery(criteriaQuery);
query.setParameter("id", id);
User result = (User)query.getSingleResult();