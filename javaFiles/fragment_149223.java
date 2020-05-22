Criteria criteria = session.createCriteria(Model.class);
criteria.add(Restrictions.eq("prop1", "A"));
criteria.createCriteria("prop2")
    .add(Restrictions.eq("x", 3));
    .add(Restrictions.eq("y", 2));
criteria.createCriteria("prop3").add(Restrictions.in("type", "Circle"));

List results = criteria.list();