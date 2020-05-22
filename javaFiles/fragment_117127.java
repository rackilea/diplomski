CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
    CriteriaQuery<Person> cq = cb.createQuery(Person.class);

    Root<Person> root = cq.from(Person.class);

    cq.select(root);

    Subquery<Category> subquery = cq.subquery(Category.class);
    Root<Person> subqueryRoot = subquery.correlate(root);
    Join<Person,Category> personCategories = subqueryRoot.join("categories");
    subquery
        .select(personCategories)
        .where(cb.equal(personCategories.get("name"), "Staff"));

    cq.where(cb.exists(subquery));

    TypedQuery<Person> typedQuery = this.entityManager.createQuery(cq);

    List<Person> resultList = typedQuery.getResultList();