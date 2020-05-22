import scala.reflect.ClassTag

class Test[@specialized(Float, Int) A: ClassTag] {
  def apply(count: Int): Array[A] = Array.tabulate(count) { 
    i => (1.5 + i).asInstanceOf[A];
  }
}

val floatTest = new Test[Float];
println(floatTest(5).mkString(", ")); // 1.5, 2.5, 3.5, 4.5, 5.5
// Works because code is specialized for float
// and primitive double is cast to primitive float.

val doubleTest = new Test[Double];
println(doubleTest(5).mkString(", ")); // 1.5, 2.5, 3.5, 4.5, 5.5
// Works although code is not specialized for double
// but Double object can be cast to Double object.

val intTest = new Test[Int];
println(intTest(5).mkString(", ")); // 1, 2, 3, 4, 5
// Works because code is specialized for int
// and primitive double is cast to primitive int.

val longTest = new Test[Long];
println(longTest(5).mkString(", ")); // ClassCastException
// Fails because code is not specialized for long
// and Double object cannot be cast to Long object.
// Works if you add @specialized(Long).