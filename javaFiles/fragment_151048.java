class XOrdering extends Ordering[Data2D] {
    override def compare(x: Data2D, y: Data2D): Int = Ordering.Int(x.x, y.x)
}

class YOrdering extends Ordering[Data2D] {
    override def comapre(x: Data2D, y: Data2D): Int = Ordering.Int(x.y, y.y)
}

private def buildTree(data: Vector[Data2D], ordering: Ordering[Data2D]): Node = {
   var sorted: Vector[Data2D] = data.sorted(ordering)
   // etc...

   ordering match {
     case _: XOrdering => buildTree(data, YOrdering)
     case _: YOrdering => buildTree(data, XOrdering)
     case _ => error("I don't know what that ordering is!")
   }
 }