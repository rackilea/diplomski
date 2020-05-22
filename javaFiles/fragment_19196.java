CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<MainGroup> query = cb.createQuery(MainGroup.class);
    Root<MainGroup> root = query.from(MainGroup.class);
    query.select(root);

    Subquery<Long> subquery = query.subquery(Long.class);
    Root<MainGroup> subRoot = subquery.from(MainGroup.class);
    subquery.select(subRoot.<Long>get("id"));
    Join<Holiday, Holiday> maingroups = subRoot.join("listHolidays");       
    subquery.where(cb.equal(maingroups.get("id"), holidayId));      

    query.where(cb.not(cb.in(root.get("id")).value(subquery))); 

    TypedQuery<MainGroup> typedQuery = em.createQuery(query);

    List<MainGroup> result = typedQuery.getResultList();