trait Exp
case class ExpAdd[A <: Exp, B <: Exp](left_arg: A, right_arg: B) extends Exp
case class ExpSub[A <: Exp, B <: Exp](left_arg: A, right_arg: B) extends Exp
case class Literal(i: Int) extends Exp

trait ExpInterpreter[E <: Exp] {
  def interpret(e: E): Int
}
object ExpInterpreter {
  implicit object LiteralInterpreter extends Interpreter[Literal] {
    def interpret(l: Literal) = l.i
  }
  implicit def addInterpreter[A <: Exp, B <: Exp](
    implicit leftInterpreter: Interpreter[A], rightInterpreter: Interpreter[B]) =
    new Interpreter[ExpAdd[A, B]] {
      def interpret(e: ExpAdd[A, B]) = leftInterpreter.interpret(e.left_arg) +
        rightInterpreter.interpret(e.right_arg)
    }
  implicit def subInterpreter ...
}