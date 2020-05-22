val rdd1  = sc.parallelize(List((("A", "X"), 1), (("A", "Y"), 2)))
val rdd2 = sc.parallelize(List(("A", 6)))
val rdd1Transformed = rdd1.map { 
   case ((letter, coord), value) => (letter, (coord, value)) 
}
val result = rdd1Transformed
  .join(rdd2)
  .map { 
    case (letter, ((coord, v1), v2)) => ((letter, coord), v1 * v2) 
  }
result.collect()
res1: Array[((String, String), Int)] = Array(((A,X),6), ((A,Y),12))