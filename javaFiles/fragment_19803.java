sealed trait Nat {
  type N <: Nat
}

// N < M
trait NatLess[N <: Nat, M <: Nat]

object NatLess {

  implicit def transitive[N <: Nat, M <: Nat, K <: Nat](implicit nm: NatLess[N, M], mk: NatLess[M, K]): NatLess[N, K] = new NatLess[N, K] {}
}

trait ToInt[N <: Nat] {
  val intValue: Int
}

object Nat {

  def toInt[N <: Nat](implicit toInt: ToInt[N]): Int = toInt.intValue

  sealed abstract class NatImpl[N <: Nat](val value: Int) extends Nat {
    implicit def toInt: ToInt[N] = new ToInt[N] {
      override val intValue = value
    }
  }

  /////////////////////////////////////////////
  sealed trait Nat50 extends Nat {
    type N = Nat50
  }

  object Nat50 extends NatImpl(50) with Nat50 {
  }

  /////////////////////////////////////////////
  sealed trait Nat100 extends Nat {
    type N = Nat100
  }

  object Nat100 extends NatImpl(100) with Nat100 {
  }

  implicit val less50_100: NatLess[Nat50, Nat100] = new NatLess[Nat50, Nat100] {}

  /////////////////////////////////////////////
  sealed trait Nat200 extends Nat {
    type N = Nat200
  }

  object Nat200 extends NatImpl(200) with Nat200 {
  }

  implicit val less100_200: NatLess[Nat100, Nat200] = new NatLess[Nat100, Nat200] {}
  /////////////////////////////////////////////

}