private List doQuery(
        final SessionImplementor session,
        final QueryParameters queryParameters,
        final boolean returnProxies) throws SQLException, HibernateException {

    final RowSelection selection = queryParameters.getRowSelection();
    final int maxRows = hasMaxRows( selection ) ?
            selection.getMaxRows().intValue() :
            Integer.MAX_VALUE;

    final int entitySpan = getEntityPersisters().length;

    final ArrayList hydratedObjects = entitySpan == 0 ? null : new ArrayList( entitySpan * 10 );
    final PreparedStatement st = prepareQueryStatement( queryParameters, false, session );
    final ResultSet rs = getResultSet( st, queryParameters.hasAutoDiscoverScalarTypes(), queryParameters.isCallable(), selection, session );

    final EntityKey optionalObjectKey = getOptionalObjectKey( queryParameters, session );
    final LockMode[] lockModesArray = getLockModes( queryParameters.getLockOptions() );
    final boolean createSubselects = isSubselectLoadingEnabled();
    final List subselectResultKeys = createSubselects ? new ArrayList() : null;
    final List results = new ArrayList();

    try {

        handleEmptyCollections( queryParameters.getCollectionKeys(), rs, session );

        EntityKey[] keys = new EntityKey[entitySpan]; //we can reuse it for each row

        if ( log.isTraceEnabled() ) log.trace( "processing result set" );

        int count;
        for ( count = 0; count < maxRows && rs.next(); count++ ) {

            if ( log.isTraceEnabled() ) log.debug("result set row: " + count);

            Object result = getRowFromResultSet( 
                    rs,
                    session,
                    queryParameters,
                    lockModesArray,
                    optionalObjectKey,
                    hydratedObjects,
                    keys,
                    returnProxies 
            );
            results.add( result );

            if ( createSubselects ) {
                subselectResultKeys.add(keys);
                keys = new EntityKey[entitySpan]; //can't reuse in this case
            }

        }

        if ( log.isTraceEnabled() ) {
            log.trace( "done processing result set (" + count + " rows)" );
        }

    }
    finally {
        session.getBatcher().closeQueryStatement( st, rs );
    }

    initializeEntitiesAndCollections( hydratedObjects, rs, session, queryParameters.isReadOnly( session ) );

    if ( createSubselects ) createSubselects( subselectResultKeys, queryParameters, session );

    return results; //getResultList(results);

}