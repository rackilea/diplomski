CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<EntityName> c = cb.createQuery(EntityName.class);
    Root<EntityName> root = c.from(EntityName.class);


    Predicate company = cb.or ( 
        cb.equal(root.<String>get("company"), "Luxoft"),
        cb.like(root.<String>get("name"), "%SoftServe%"));

    Predicate location = cb.or ( 
        cb.equal(root.<String>get("location"), "Kiev"),
        cb.like(root.<String>get("location"), "%Lviv%"));

    Expression<String> typeExpression = root.get("type");

    Predicate type = typeExpression.in("Java", "Javascript");

    c.where(company, location, type);

    return c.getResultList();