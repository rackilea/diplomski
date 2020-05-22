Criteria criteria = session.createCriteria(Son.class);           
    criteria.createAlias("father", "father");
    criteria.createAlias("toyList", "toy");
    criteria.createAlias("toy.featureList", "feature");
    criteria.add(Restrictions.eq("father.id", 1));
    criteria.add(Restrictions.eq("feature.unisex", true));