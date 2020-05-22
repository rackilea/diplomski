session.createCriteria(Whatever.class)
    .add(Restrictions.disjunction()
        .add(Restrictions.eq("name", queryString))
        .add(Restrictions.eq("address", queryString))
        .add(Restrictions.eq("phoneNumber", queryString))
    );