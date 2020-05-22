object FunctionConverterFromJava extends FunctionConverterFromScala {
  ...
  val intoEvenOddForJava: function.Function[JList[java.lang.Integer], (JList[java.lang.Integer], JList[java.lang.Integer])] = {
    intoEvenOdd.asJava.asInstanceOf[function.Function[JList[java.lang.Integer], (JList[java.lang.Integer], JList[java.lang.Integer])]]
  }
}