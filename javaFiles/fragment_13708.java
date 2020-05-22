// Initialize with capacity=7
scala> new HashMap[String,String](7)
res0: java.util.HashMap[String,String] = {}

scala> getPrivate(res0, "table").length
res1: Int = 8

scala> ... put 7 values

// Still internally using the same array
scala> getPrivate(res0, "table").length
res9: Int = 8

// Specifying capacity 9 allocates a 16-lenth array
scala> getPrivate(new HashMap[String,String](9), "table").length
res10: Int = 16

// Copying our first map into a new map interestingly
// also allocates the default 16 slots, rather than 8
scala> getPrivate(new HashMap[String,String](res0), "table").length
res11: Int = 16

scala> ... put 10 more values in our map

scala> getPrivate(res0,"table").length
res22: Int = 32

// Copying again immediately jumps to 32 capacity
scala> getPrivate(new HashMap[String,String](res0),"table").length
res23: Int = 32