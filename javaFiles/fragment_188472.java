for ( Object projectId : projectIds ) {
  List results = reader.createQuery()
     .forRevisionsOfEntity( Project.class, false, false )
     .add( AuditEntity.id().eq( projectId ) )
     .addOrder( AuditEntity.revisionNumber().asc() );
  // At this point you have an list of object array values 
  // Index 0 - This is the instance of Project 
  // Index 1 - This is the revision entity, you can get the rev # and timestamp
  // Index 2 - Type of revision, see RevisionType
  //
  // So you can basically iterate the list in ascending order keeping track of
  // the prior Project and build a changeset for each project.
  //
  // This approach is often more efficient if you're needing to compare multiple
  // attributes on an entity rather than issuing a query to the database for 
  // each change made to a single property.
}