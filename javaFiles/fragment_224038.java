Insert insert1 = QueryBuilder.insert...
Batch batch = QueryBuilder.batch(insert1);
Insert insert2 = QueryBuilder.insert...
batch.add(insert2);

CassandraOperations cassandraOperations = new CassandraTemplate(session);
WriteOptions options = new WriteOptions();
options.setTtl(60);
options.setConsistencyLevel(ConsistencyLevel.ONE);
options.setRetryPolicy(RetryPolicy.DOWNGRADING_CONSISTENCY);
cassandraOperations.execute(batch.toString(), options);