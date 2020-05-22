class TheClass { 
  def theMethod:Unit = { println("It's me the method"); } 
}

scala> classOf[TheClass].getDeclaredMethod("theMethod").invoke(new TheClass, null)
java.lang.IllegalArgumentException: wrong number of arguments
  at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)

scala> classOf[TheClass].getDeclaredMethod("theMethod").invoke(new TheClass)
It's me the method
res1: Object = null