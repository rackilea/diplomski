// create a 'DetachedCriteria' query for all the items in 'B'
DetachedCriteria dc = DetachedCriteria.forClass(B.class).setProjection(
    Projections.projectionList().add(Projections.property("propertyInB")) 
);

// then: search for A.id by adding 'dc' as asubquery:        
session.createCriteria(A.class).add(
    Subqueries.propertiesIn( new String[]{"propertyInA"}, dc)
).list();