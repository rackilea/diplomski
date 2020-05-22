package test

object TypeEnum extends Enumeration {
  type TypeEnum=Value
  val A, B, C, D = Value
}

import TypeEnum._

case class Foo(param1: TypeEnum, param2: List[Int])