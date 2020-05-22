import java.nio.ByteBuffer
trait BufferWriter[@specialized(Byte,Int) A]{
  def write(b: ByteBuffer, a: A): Unit
}
class ByteWriter extends BufferWriter[Byte] {
  def write(b: ByteBuffer, a: Byte) { b.put(a) }
}
class IntWriter extends BufferWriter[Int] {
  def write(b: ByteBuffer, a: Int) { b.putInt(a) }
}
object BufferWriters {
  implicit val byteWriter = new ByteWriter
  implicit val intWriter = new IntWriter
}