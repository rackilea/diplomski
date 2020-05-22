Criteria criteria = getSession().createCriteria(A.class, "a");
criteria.createAlias("a.b", "b");
criteria.createAlias("b.cList", "c");
criteria.createAlias("c.dList", "d");
criteria.add(Restrictions.eq("a.someProperty", "somethingelse");
criteria.add(Restrictions.eq("d.importantAttribute", "something");