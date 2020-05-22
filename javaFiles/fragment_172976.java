protected void updateJoinTables()
{
    if ( !roleToRole.isEmpty() )
    {
        return;
    }

    Map<String, List<String>> joinTableToRoles = new HashMap<>();

    LocalSessionFactoryBean sessionFactoryBean = getLocalSessionFactoryBean();
    SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor) sessionFactory;
    Iterator iterator = sessionFactoryBean.getConfiguration().getCollectionMappings();

    while ( iterator.hasNext() )
    {
        Collection collection = (Collection) iterator.next();
        CollectionPersister persister = sessionFactoryImplementor.getCollectionPersister( collection.getRole() );

        if ( persister.isManyToMany() && collection.getType().isAssociationType() )
        {
            AssociationType associationType = (AssociationType) collection.getType();
            Joinable associatedJoinable = associationType.getAssociatedJoinable( sessionFactoryImplementor );

            if ( !joinTableToRoles.containsKey( associatedJoinable.getTableName() ) )
            {
                joinTableToRoles.put( associatedJoinable.getTableName(), new ArrayList<String>() );
            }

            joinTableToRoles.get( associatedJoinable.getTableName() ).add( collection.getRole() );
        }
    }

    Iterator<Map.Entry<String, List<String>>> entryIterator = joinTableToRoles.entrySet().iterator();

    while ( entryIterator.hasNext() )
    {
        Map.Entry<String, List<String>> entry = entryIterator.next();

        if ( entry.getValue().size() < 2 )
        {
            entryIterator.remove();
        }
    }

    for ( Map.Entry<String, List<String>> entry : joinTableToRoles.entrySet() )
    {
        roleToRole.put( entry.getValue().get( 0 ), entry.getValue().get( 1 ) );
        roleToRole.put( entry.getValue().get( 1 ), entry.getValue().get( 0 ) );
    }
}