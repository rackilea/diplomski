sealed trait ArbiterResponse[+Tasks]{
  def doSomething
}

object Reject extends ArbiterResponse[Nothing]{
  def doSomething = ???
}

trait Proceed[Tasks] extends ArbiterResponse[Tasks]
object Proceed extends Proceed[Nothing]{
  def doSomething = ???
}
case class ProceedConditionally[Tasks](tasks : Tasks) extends Proceed[Tasks]{
  def doSomething = println(tasks)
}