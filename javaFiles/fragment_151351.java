Cluster cluster = ...
QueryLogger queryLogger = QueryLogger.builder(cluster)
    .withConstantThreshold(...)
    .withMaxQueryStringLength(...)
.build();
cluster.register(queryLogger);