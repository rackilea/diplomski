List<Person> myQueryMethod(<some params>) {
    FullTextEntityManager em = ...;
    Query luceneQuery = ...;
    FullTextQuery query = em.createFullTextQuery( luceneQuery, WriteablePerson.class );
    query.setProjection( org.hibernate.search.engine.ProjectionConstants.ID );
    List<Object[]> projections = query.getResultList();
    return loadResults( Person.class, projections );
}

<T> List<T> loadResults(Class<T> clazz, List<Object[]> idProjections) {
    List<Serializable> ids = new ArrayList<>( idProjections.size() );
    for ( Object[] projection : idProjections ) {
        ids.add( (Serializable) projection[0] );
    }
    return em.unwrap( Session.class ).byMultipleIds( clazz )
        .with( CacheMode.<pick a cache mode> ) // May be ommitted
        .withBatchSize( <pick a batch size> ) // May be ommitted
        .multiLoad( ids );
}