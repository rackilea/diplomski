int num_partitions;
  num_partitions = 10;
  Properties connectionProperties = new Properties();
  connectionProperties.put("user", "test");
  connectionProperties.put("password", "test##");
  connectionProperties.put("partitionColumn", "hash_code");
  String query = "(SELECT  mod(A.id,num_partitions)  as hash_code, A.* from items A)";
  dataFileContent = spark.read()
    .jdbc("jdbc:oracle:thin:@//172.20.0.11/devad",
      dbtable = query,
      columnName = "hash_code",
      lowerBound = 0,
      upperBound = num_partitions,
      numPartitions = num_partitions,
      connectionProperties);