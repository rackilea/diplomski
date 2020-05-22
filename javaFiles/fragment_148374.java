// gpc.run()
for (i <- 1 to count) {
  ...
  val length = gpc.send(result)
  println(s"Sent: $i $length")
}

... in initializer
gpc = new GpcSocket()