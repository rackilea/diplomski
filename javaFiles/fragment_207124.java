/** Implementation of the java api in 
  * Scala
  */
class A_javaApiImpl extends A_j {
  private val wrappedA: A = new A

  private class B_javaApiImpl[X](val x: X) extends B_j[X] {
    private val wrappedB: wrappedA.B[X] = new wrappedA.B[X](x)
    def superImportantMethod: String = wrappedB.superImportantMethod
  }

  def createB[X](x: X): B_j[X] = new B_javaApiImpl[X](x)
}