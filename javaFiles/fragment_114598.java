import BufferWriters._
def write[@specialized(Byte,Int) A: BufferWriter](b: ByteBuffer, ar: Array[A]) {
  val writer = implicitly[BufferWriter[A]]
  var i = 0
  while (i < ar.length) {
    writer.write(b, ar(i))
    i += 1
  }
}