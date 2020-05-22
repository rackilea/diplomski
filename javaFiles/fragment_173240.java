object `package` {
  val A = AX
}

object AX {
  def unapply(a: A): Option[Int] = Some(a.getI)
}

object Test extends App {
  Console println {
    new A(42) match {
      case A(i) => i
    }
  }
}