trait TypeControlInterface[T]
trait Parent[T] extends TypeControlInterface[T]

trait Node
case class Label(s: String) extends Node

object Test {
  def as[TYPE, INTERFACE <: TypeControlInterface[TYPE]](interfaceClass: Class[INTERFACE], typeClass: Class[TYPE]): INTERFACE = ???

  def main(args: Array[String]) {
    val label1 = as(classOf[Parent[Label]], classOf[Label]) // compiles
    val label2 = as(classOf[Parent[Node]], classOf[Node]) // compiles
    val label3 = as(classOf[Parent[Label]], classOf[Node]) // doesn't compile
  }
}