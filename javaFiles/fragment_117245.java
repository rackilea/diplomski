int pageNumber = 1;
int pageSize = 10;
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
countQuery.select(criteriaBuilder.count(countQuery.from(Foo.class)));
Long count = entityManager.createQuery(countQuery).getSingleResult();

CriteriaQuery<Foo> criteriaQuery = criteriaBuilder.createQuery(Foo.class);
Root<Foo> from = criteriaQuery.from(Foo.class);
CriteriaQuery<Foo> select = criteriaQuery.select(from);
select.where(criteriaBuilder.equal(fromRoot.get("entityColumb"), "bar")));

TypedQuery<Foo> typedQuery = entityManager.createQuery(select);
while (pageNumber < count.intValue()) {
    typedQuery.setFirstResult(pageNumber - 1);
    typedQuery.setMaxResults(pageSize);
    System.out.println("Current page: " + typedQuery.getResultList());
    pageNumber += pageSize;
}