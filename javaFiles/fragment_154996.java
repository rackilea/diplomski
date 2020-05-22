abstract class ArrayOpsBase[T <: AnyVal] ( val coords: Array[T] ) {
  protected val length = coords.length
  protected def allocateBb(mod: Int) = {
    ByteBuffer.allocateDirect(length * mod)
    .order(ByteOrder.nativeOrder())
  }
  def buffer(): Buffer
}

implicit class FloatArrayBufferOps( coords: Array[Float] ) extends ArrayOpsBase[Float]( coords ) {
  def buffer = allocateBb(4).asFloatBuffer.put( coords ).position( 0 )
}
implicit class ShortArrayBufferOps( coords: Array[Short] ) extends ArrayOpsBase[Short]( coords ) {
  def buffer = allocateBb(2).asShortBuffer.put( coords ).position( 0 )
}