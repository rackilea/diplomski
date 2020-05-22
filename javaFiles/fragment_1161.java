class JsonToXmlParserTest extends Suite with Matchers with AssertionsForJUnit {
  @Test
  def testBigDecimalPrecision(): Unit = {
    val decimalString = "12345678901234567890.12345678901234567890"
    val bigDecimal = BigDecimal(decimalString, MathContext.UNLIMITED)
    val javaBigDecimal = new java.math.BigDecimal(decimalString, MathContext.UNLIMITED)

    javaBigDecimal.compareTo(bigDecimal.bigDecimal) should be(0)
  }

}