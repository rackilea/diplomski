@Autowired
private CqlOperations cqlTemplate;//or inherited interface, like CassandraOperations

private void insertEventUsingPreparedStatement() {
  PreparedStatement preparedStatement = cqlTemplate.getSession().prepare("insert into event (id, type, bucket, tags) values (?, ?, ?, ?)");
  Statement insertStatement = preparedStatement.bind(UUIDs.timeBased(), "type2", TIME_BUCKET, ImmutableSet.of("tag1", "tag2"));
  cqlTemplate.execute(insertStatement); 
}