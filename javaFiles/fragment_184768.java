object Hbase_Scan_TimeRange {

  def main(args: Array[String]): Unit = {
    //===Basic Hbase (Non Deprecated)===Start
    Logger.getLogger(this.getClass)
    Logger.getLogger("org").setLevel(Level.ERROR)
    BasicConfigurator.configure()
    val conf = HBaseConfiguration.create()
    val connection = ConnectionFactory.createConnection(conf)
    val admin  = connection.getAdmin()
    //===Basic Hbase (Non Deprecated)===End

    val scans = new Scan()
    scans.setMaxVersions(1)
    val _min = 1470387596203L
    val _max = 1470387596204L
    scans.setTimeRange(1470387596203L, 1470387596204L)

    val table = connection.getTable(TableName.valueOf("tm_movie"))
    val scanner  = table.getScanner(scans)
    val result = scanner.iterator()
    while(result.hasNext)
    {
        val data = result.next()
        val movieId = Bytes.toString(data.getValue(Bytes.toBytes("data"),Bytes.toBytes("movieId")))
        val movieName = Bytes.toString(data.getValue(Bytes.toBytes("data"),Bytes.toBytes("movieName")))
        val movieGenre = Bytes.toString(data.getValue(Bytes.toBytes("data"),Bytes.toBytes("movieGenre")))

        println()
        println("movieGenre::"+movieGenre)
        println("movieName::"+movieName)
        println("movieId::"+movieId)
    }

  }
}