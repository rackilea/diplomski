/* Suppose that this is the external Scala library 
 * that you cannot change.
 * A = Outer
 * B = Inner
 * 
 * + I added at least one member and one
 * method, so that it's not so boring and trivial
 */

class A {
  var superImportantMemberOfA: Int = 42
  class B[T](t: T) {
    def superImportantMethod: String = t + "" + superImportantMemberOfA
  }
}