// an ill-behaved ListHandler
class HandlerImpl<T> : ListHandler<T> {
    private var storage: List<T> = listOf()    
    override fun handle(result: List<T>) { storage = result }    
    override fun get(): List<T> = storage    
}

// Code using it, that breaks
fun main(args: Array<String>) {
    val anyHandler = HandlerImpl<Any>()
    anyHandler.handle(listOf(1, 2, 3))

    val problematic: ListHandler<String> = anyHandler
    // The following line requires an element to be a String, but it is an Int
    problematic.get()[0].length() 
}