Long min = 0l;
Long max = 100l;

DetachedCriteria subquery = DetachedCriteria.forClass(TableA.class, "inner")
                .createAlias("tableC", "tableC", JoinType.LEFT_OUTER_JOIN)
                .createAlias("tableB", "tableB")
                .setProjection(Projections.sqlProjection("coalesce(sum(amountC), 0) + amountB", new String[] {"compositeSum"}, new Type[] {StandardBasicTypes.LONG}))
                .add(Restrictions.eqProperty("id", "this.id"));

Criteria criteria = session().createCriteria(TableA.class, "outer")
                .setProjection(Projections.property("id"))
                .add(Subqueries.ge(max, subquery))
                .add(Subqueries.le(min, subquery));