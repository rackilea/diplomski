CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
CriteriaQuery<Foo> query = cb.createQuery(Foo.class);
Root<Foo> root = query.from(Foo.class);
ParameterExpression<Long> paramOne = cb.parameter(Long.class);
Predicate versionPredicate = root.get("bar").in(paramOne);
query.select(root).where(versionPredicate);
TypedQuery<Foo> typedQuery = getEntityManager().createQuery(query);
typedQuery.setParameter(paramOne, 1L);