case class ShapeFunctions[T](draw: T => Unit, area: T => Double)
object ShapeFunctions {
  val circleFunctions = new ShapeFunctions[Circle]({c: Circle => ...}, {c: Circle => ...})
  val squareFunctions = new ShapeFunctions[Square](...)
  def forShape(shape: Any) = if(isCircle(shape)) circleFunctions
    else if(isSquare(shape)) squareFunctions
    else ...
}
def drawShapes(shapes: List[Shape]) =
  for {shape <- shapes}
    ShapeFunctions.forShape(shape).draw(shape)