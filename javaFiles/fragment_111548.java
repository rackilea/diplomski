import scala.util.parsing.combinator.RegexParsers

object Parser extends RegexParsers {
  def intPair = INT ~ "," ~ INT ^^ { x => (x._1._1.toInt,x._2.toInt) }
  val INT = "[0-9]+".r
}


Parser.parseAll(Parser.intPair, "10,22") // => (10,22)