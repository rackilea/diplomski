Criteria rootCriteria = createCriteria(entityClass);
    rootCriteria.add(Restrictions.or(
            Restrictions.eq("a","a"),
            Restrictions.and(
                    Restrictions.eq("b","b"),
                    Restrictions.eq("c","c")
            )
    ));