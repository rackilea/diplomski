// numPartitions == number of simultaneous DB connections you can afford
  yourRdd.repartition(numPartitions)
  .foreachPartition {
    iter =>
      val connection = createConnection()
      while (iter.hasNext) {
        connection.execute("INSERT ...")
      }
      connection.commit()
  }