getCurrentSession().createCriteria(User.class)
.setProjection( Projections.distinct( Projections.projectionList()
.add( Projections.property("name"), "name")
.add( Projections.property("city"), "city")))
.add( Restrictions.eq("city", "TEST")))
.setResultTransformer(Transformers.aliasToBean(User.class))
.list();