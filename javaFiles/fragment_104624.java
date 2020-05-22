scala> abstract class MyOrdered extends Ordered[MyOrdered] {
     |     def id: Int
     |     def compare(that : MyOrdered) : Int =
     |         if (that==null) 1 else (id-that.id)
     | }
defined class MyOrdered