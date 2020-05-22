Criteria cr1 = session.createCriteria(Suppliers.class);
 cr1.setProjection(Projections.projectionList()
    .add( Projections.property("supplier_id"), "supplier_id" )
 );
List results1 = cr1.list();

Criteria cr2 = session.createCriteria(Orders.class);
 cr2.setProjection(Projections.projectionList()
    .add( Projections.property("supplier_id"), "supplier_id" )
 );
List results2 = cr2.list();

results1.add(results2); 

List unionAllList =  results1; //this is the expected result.