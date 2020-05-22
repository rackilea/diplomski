val cluster2 = CassandraConnector eventsConnector = 
  CassandraConnector.apply(
    sc.getConf()
      .set("spark.cassandra.connection.host", "192.168.36.234"));

  javaFunctions(sc).cassandraTable(ks, "test_table").withConnector(cluster2).collect()
}