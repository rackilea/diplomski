import scala.reflect.runtime.universe._

class C[I, O]

class A[T: TypeTag] {
  val tpe = typeOf[T]
}

val a = new A[C[Integer, String]]
println(a.tpe) // C[java.lang.Integer,String]