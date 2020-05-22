DetachedCriteria a = DetachedCriteria.forClass(Pin.class);
    String groupBy = "wireId having count(DISTINCT type) >=2";
    String[] alias = new String[1];
    alias[0] = "wireId ";
    Type[] types = new Type[1];
    types[0] = Hibernate.STRING;

    a.setProjection(Projections.sqlGroupProjection("wireId", groupBy, alias, types));
    criteriaQuery.add(Subqueries.propertyIn("wireId", a));