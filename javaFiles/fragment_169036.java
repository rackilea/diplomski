Criteria criteria = session.createCriteria(clazz);

    for(Criterion c : criterions){
        criteria.add(c);
    }

    criteria.setFirstResult(start);
    criteria.setMaxResults(size);

    List records = criteria.list();