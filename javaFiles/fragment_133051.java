class FooString extends Foo {
  def bar[T](c: Class[T]): T = c.newInstance.asInstanceOf[T] // c gotta have a default constructor
}

val fs = new FooString
println(fs.bar(classOf[String]).getClass) // prints "class java.lang.String"
println(fs.bar(classOf[java.util.Date]).getClass) // prints "class java.util.Date"