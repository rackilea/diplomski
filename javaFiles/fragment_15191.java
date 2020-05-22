Criteria criteria = db.getSession().createCriteria(Vendor.class, "vendor");

DetachedCriteria dc = DetachedCriteria.forClass(Vendor.class, "vendor2");
dc.createAlias("vendor2.models", "model");
dc.add(Restrictions.eq("model.deprecated", 0));
dc.add(Restrictions.eqProperty("vendor2.id", "vendor.id"));
dc.setProjection(Projections.id());

criteria.add(Subqueries.notExists(dc));