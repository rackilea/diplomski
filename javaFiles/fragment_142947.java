scala> :paste
// Entering paste mode (ctrl-D to finish)

class Store(val name: String){
    override def equals(that: Any) : Boolean = {
         val thatStore = that.asInstanceOf[Store]
         name == thatStore.name
    }
}

scala> new Store("JWN") == new Store("JWN") // calls s1.equals(s2)
res1: Boolean = true