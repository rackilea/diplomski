import scala.language.higherKinds

object Main extends App {
  val builder1 = HCons(23, HCons("Hello", HNil))
  val builder2 = HCons(42L, builder1)

  val res1:String = builder1.apply(i => s => i + s)
  val res2:String = builder2.apply(l => i => s => (i+l) + s)
  println(res1) // 23Hello
  println(res2) // 65Hello
}

sealed trait HList {
  type F[Res]
  def apply[Res]: F[Res] => Res
}
case class HCons[Head, HTail <: HList](head: Head, tail: HTail) extends HList {
  type F[Res] = Head => (tail.type)#F[Res]
  def apply[Res]: F[Res] => Res = f => tail.apply(f(head))
}
case object HNil extends HList {
  type F[Res] = Res
  def apply[Res]: F[Res] => Res = identity
}