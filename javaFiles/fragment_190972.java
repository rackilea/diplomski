import org.apache.spark.HashPartitioner

val rdd = sc.parallelize(
  Seq(("a", 1), ("b", 2), ("c", 3), ("a", 4), ("b", 5)
// A particular number is used only to get a reproducible output
)).partitionBy(new HashPartitioner(8))  

val keys = Set("a", "c")
val parts = keys.map(_.## % rdd.partitions.size)

rdd.mapPartitionsWithIndex((i, iter) =>
  if (parts.contains(i)) iter.filter{ case (k, _) => keys.contains(k) }
  else Iterator()
).collect

// Array[(String, Int)] = Array((a,1), (a,4), (c,3))