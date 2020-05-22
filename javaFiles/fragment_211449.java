val intoEvenOddAsJava: JList[java.lang.Integer] => (JList[java.lang.Integer], JList[java.lang.Integer]) = {
  import scala.jdk.CollectionConverters._
  javaList: JList[java.lang.Integer] =>
    javaList.asScala.partition(_ % 2 == 0) match {
      case (even: mutable.Buffer[java.lang.Integer], odd: mutable.Buffer[java.lang.Integer]) =>
        (even.asJava, odd.asJava)
    }
}