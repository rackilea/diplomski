import collection.mutable.ListBuffer
def splitBySeparator[T]( l: Seq[T], sep: T ): Seq[Seq[T]] = {
  val b = ListBuffer(ListBuffer[T]())
  l foreach { e =>
    if ( e == sep ) {
      if  ( !b.last.isEmpty ) b += ListBuffer[T]()
    }
    else b.last += e
  }
  b.map(_.toSeq)
}