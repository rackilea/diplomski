class FooString extends Foo {
  def bar[String](c: Class[String]): String = "hello world".asInstanceOf[String]
}

val fs = new FooString
println(fs.bar(classOf[String]))