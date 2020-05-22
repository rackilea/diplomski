Criteria criteria = session.createCriteria(Father.class);           
criteria.createAlias("sonList", "son");
criteria.createAlias("son.toyList", "toy");
criteria.createAlias("toy.featureList", "feature");
criteria.add(Restrictions.idEq(1));
criteria.add(Restrictions.eq("feature.unisex", true));