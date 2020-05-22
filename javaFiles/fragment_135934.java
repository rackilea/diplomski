val rand = new java.util.Random
val n = 50
val k = 4
val map = 0 until n map (i => {
  i -> ((0 until k) map (_ => rand.nextInt(n)) filter (_ != i) groupBy(identity) map (_._1) toList)
}) toMap