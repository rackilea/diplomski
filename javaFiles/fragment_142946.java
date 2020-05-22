scala> class Store(name: String){} //equivalent to Store extends `AnyRef`
defined class Store

scala> val store1 = new Store("a")
store1: Store = Store@2063c53e

scala> val store2 = new Store("a")
store2: Store = Store@61c76850

scala> store1 == store2
res7: Boolean = false