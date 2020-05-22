sealed trait Operation {
  /** Combine the existing number with the new digits under the current operation. */
  def combine(x: Double, y: Seq[Int]): Double
}

case object Decimal extends Operation {
  def combine(x: Double, y: Seq[Int]) = ???
}

case object Add extends Operation {
  def combine(x: Double, y: Seq[Int]) = ???
}