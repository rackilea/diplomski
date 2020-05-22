B b ...
CriteriaQuery<Aa> cq = cb.createQuery(A.class);
ParameterExpression<B> param = cb.parameter(B.class);
Root<A> a = cq.from(A.class);
Expression<Collection<B>> disabledB = a.get("disableForB");
Predicate pred = cb.isNotMember(param, disabledB);
cq.select(a);
cq.where(pred);
em.createQuery(cq).setParameter(param, b).getResultList();