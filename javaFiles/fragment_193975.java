datasetOfString.write.foreach(new ForeachWriter[String] {

     def open(partitionId: Long, version: Long): Boolean = {
       // open connection
     }

     def process(record: String) = {
       // write string to connection
     }

     def close(errorOrNull: Throwable): Unit = {
       // close the connection
     }
   })