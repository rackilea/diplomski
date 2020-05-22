if (!Thread.interrupted()) {

    initializeEntitiesAndCollections(hydratedObjects, rs, session,
                queryParameters.isReadOnly(session));
    if (createSubselects) {

        createSubselects(subselectResultKeys, queryParameters, session);
    }
}