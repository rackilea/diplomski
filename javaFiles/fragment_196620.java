trait Token[T]{
  def stringValue: String 
  def value: T
}

object ReservedSymbolEnum extends Enumeration {
  type ReservedSymbolEnum = Value
  val `class`, `void` = Value
      val NullValue = Value("null") // Alternative without quoting
}

case class ReservedSymbol(override val stringValue: String)extends Token[ReservedSymbolEnum.ReservedSymbolEnum] {
  def value = ReservedSymbolEnum.withName(stringValue)
}

case class StringLiteral(override val stringValue: String) extends Token[String] {
  override def value = stringValue
}

case class IntegerLitaral(override val stringValue: String) extends Token[Int] {
  override def value = stringValue.toInt
}