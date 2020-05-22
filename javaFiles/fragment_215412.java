class Parent(val s: String)

class Child() extends Parent(Child.param)

object Child {
  val param = "I_AM_NEEDED"
}