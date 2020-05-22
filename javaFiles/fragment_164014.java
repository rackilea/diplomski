class CheckedStack<E>(private val array: Array<E?>, private val isNullable: Boolean) : Stack<E> {

    companion object {
        // This method invocation looks like constructor invocation
        inline operator fun <reified E> invoke(size: Int): CheckedStack<E> {
            return CheckedStack(arrayOfNulls(size), null is E)
        }
    }

    private var index: Int = -1

    override fun push(elem: E) {
        if (!isNullable) elem!!
        check(index < array.size - 1)
        array[++index] = elem
    }

    override fun pop(): E {
        check(index >= 0)
        @Suppress("UNCHECKED_CAST")
        return array[index--] as E
    }
}