case class Stock(line: String) {
  val data = line.split(",")
  val date = data(0)
  val open = data(1).toDouble
  val high = data(2).toDouble
  val low = data(3).toDouble
  val close = data(4).toDouble
  val volume = data(5).toDouble
  val adjClose = data(6).toDouble

  def price: Double = low
}

scala> import scala.io._

scala> Source.fromFile("stock.csv") getLines() map (l => Stock(l))
res0: Iterator[Stock] = non-empty iterator


scala> res0.toSeq  
res1: Seq[Stock] = List(Stock(2010-03-15,37.90,38.04,37.42,37.64,941500,37.64), Stock(2010-03-12,38.00,38.08,37.66,37.89,834800,37.89) //etc...