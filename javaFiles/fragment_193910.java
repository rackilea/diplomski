import java.lang.Comparable

class MyComparable[T <: Comparable[_>:Tb],Tb]()(implicit ev: T=:=Tb) {
  def this(a: T)(implicit ev: T=:=Tb) = {
    this()
    println(a)
  }
}