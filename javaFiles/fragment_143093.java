DetachedCriteria crit          = DetachedCriteria.forClass( Parent.class, "theparent" );
DetachedCriteria countSubquery = DetachedCriteria.forClass( Child.class , "child"     );

countSubquery
    .add( Property.forName("theparent.id").eqProperty( "parent.id" ) )
    .setProjection(Projections.count("id"));

crit.add(Subqueries.lt(Long.valueOf(0), countSubquery));