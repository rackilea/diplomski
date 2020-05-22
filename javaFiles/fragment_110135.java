class MyClass extends AutoCloseable {
    override def close(): Unit = println("Closing!")
  }

  def foo: Try[Int] = {
     autoCloseTry(new MyClass) { _ => return Success(0) }
  }

  println(foo)