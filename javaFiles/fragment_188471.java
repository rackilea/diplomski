// you might want to check if this collection is empty
// it should not be assuming you aren't removing data from the audit tables
// but sometimes people archive data, so its best to be thorough
List<Number> revs = reader.getRevisions( Contractor.class, contractorId );

// The list of revisions are always in ascending order, so grab the last entry.
Number maxRevision = revs.get( revs.size() - 1 );

// Build the projection query
// This returns us the list of project ids, just like the HQL above
List projectIds = reader.createQuery()
   .forEntitiesAtRevision( Contractor.class, maxRevision )      
   .traverseRelation( "projects", JoinType.INNER )
   .addProjection( AuditEntity.property( "id" ).distinct() )
   .up()
   .add( AuditEntity.id().eq( contractorId ) )
   .getResultList();