val spark = SparkSession.builder.master("local[*]").appName("partitionIndex").getOrCreate()
import spark.implicits._

val ds = spark.createDataset(Seq.range(1, 21)).repartition(4)
ds.rdd
  .mapPartitionsWithIndex((partitionIndex, it) => {
    println("processing partition " + partitionIndex)
    it.toList.map(i => new String("partition " + partitionIndex + " contains number " + i)).iterator
  })
  .foreach(println)