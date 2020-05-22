interface HasStuff { val stuff:SharedStuff }

data class SharedStuff(val a:Int, val b:String)
data class Class1(override val stuff:SharedStuff, val other:String) : HasStuff
data class Class2(override val stuff:SharedStuff, val specific:Int) : HasStuff

class Container {
    private var items = listOf<HasStuff>()
    fun add(a:HasStuff) { items += a }
}