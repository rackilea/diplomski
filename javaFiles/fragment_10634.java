class Split(val left: TreeElem, val right: TreeElem) : TreeElem {
    override fun <T> accept(visitor: TreeVisitor<T>): T {
        return visitor.combine(listOf(
                visitor.visit(this),
                left.accept(visitor),
                right.accept(visitor)))
    }
}

interface TreeVisitor<T> {
    fun combine(inputs: List<T>): T
    // ...
}

class Printer : TreeVisitor<CharSequence> {
    override fun combine(inputs: List<CharSequence>): CharSequence {
        return inputs.joinToString(" ")
    }
    // ...
}