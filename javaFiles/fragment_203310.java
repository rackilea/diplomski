class NumMath(u: Num) {
  def +(v: Num) = Num(u.value + v.value)
  def *(v: Num) = Num(u.value * v.value)
}

object Num {
  implicit def toNumMath(v: Num) = new NumMath(v)
}
case class Num(value: Double)

object Main {
  import Num._
  def main(args: Array[String]) {
    val one = Num(1)
    val two = Num(2)
    val three = Num(3)
    val result = three + one * two
    println(result)
  }
}