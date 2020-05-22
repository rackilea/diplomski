Cluster cluster = Cluster.builder()
    .addContactPoints(...)
    // other options...
    .withQueryOptions(
        new QueryOptions()
            .setRefreshNodeIntervalMillis(0)
            .setRefreshNodeListIntervalMillis(0)
            .setRefreshSchemaIntervalMillis(0)
    ).build();