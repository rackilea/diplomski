case class Num(value: Double)

object Main {
  implicit def toDouble(v: Num) = v.value
  implicit def toNum(v: Double) = Num(v)
  def main(args: Array[String]) {
    val one = Num(1)
    val two = Num(2)
    val three = Num(3)
    val result: Num = three + one * two
    println(result)
  }
}