CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
CriteriaDelete<SomeClass> query = criteriaBuilder.createCriteriaDelete(SomeClass.class);
Root<SomeClass> root = query.from(SomeClass.class);
query.where(root.get("id").in(listWithIds));

int result = entityManager.createQuery(query).executeUpdate();