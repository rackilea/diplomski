List result = session.createCriteria( Bank.class )
.setProjection( Projections.projectionList()
.add( Projections.property( "person.name" ) )
.add( Projections.property( "person.phone" ) )
.add( Projections.property( "phone" ) )
).list();