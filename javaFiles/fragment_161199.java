import collection.immutable._

class MyClass2 {
  // ...
}

// We can make the default constructor private, if we want to manage the
// map ourselves instead of allowing users to pass arbitrary maps
// (depends on your use case):
class MyClass private (val myData: Map[String,MyClass2]) {
  // A public constructor:
  def this() = this(new HashMap[String,MyClass2]())

  def someMethod(id: String): MyClass = {
    if (myData.contains(id))
      new MyClass(myData - id) // create a new, updated instance
    else {
      println("Not found: " + id)
      this // no modification, we can return the current
            // unmodified instance
    }
  }

  // other methods for adding something to the map
  // ...
}