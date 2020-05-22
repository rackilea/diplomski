class C(a: A = aDefault, b: B = C.bDefault) {
  def this() { this(b = C.bDefault) }
}
object C { def bDefault = ... }

// OR

class C(a: A = aDefault, b: B) {
  def this() { this(b = bDefault) }
}