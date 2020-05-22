val javaTest = new JavaTest[String]

class TMijavatest[T] extends IJavaTest[T] {
  override def ss(): String = ""
}

val foo = new TMijavatest[String]

javaTest.add(foo)