object MainExp {
  def main(args: Array[String]): Unit = {
    if (args.length != 5) {
      println("Invalid number of arguments!")
    } else {
      val dbName = args(0)
      val collectionName = args(1)
      val numberOfClusters = args(2)
      val categories = args(3).split(',').toList
      val columns = args(4).split(',').toList
      println("Database=%s\nCollection=%s\nClusters=%s\n".format(dbName, collectionName, numberOfClusters))
      println("Categories: length=%s".format(categories.length))
      categories.foreach(x => println("\t%s".format(x)))
      println("Columns: length=%s".format(columns.length))
      columns.foreach(x => println("\t%s".format(x)))
    }
  }
}