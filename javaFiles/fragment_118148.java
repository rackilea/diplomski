scala> :paste
// Entering paste mode (ctrl-D to finish)

implicit class ByteOps(v: Byte) {
  def toJavaByte: java.lang.Byte = java.lang.Byte.valueOf(v.toString)
}

// Exiting paste mode, now interpreting.

defined class ByteOps

scala> val a: Byte = 1
a: Byte = 1

scala> a.toJavaByte
res4: Byte = 1