open class Base {
    open val size: Int = 0
    init { println("size = $size") }
}

class Derived : Base() {
    val items = mutableListOf(1, 2, 3)
    override val size: Int get() = items.size
}