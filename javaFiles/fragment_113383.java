trait Shape {
  def draw(): Unit
  def area(): Double
}
class Circle extends Shape {
  val center: (Double, Double)
  val radius: Double
  def draw() = {...}
  def area() = {...}
}