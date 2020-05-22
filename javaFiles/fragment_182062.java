inline fun <T> doIfNotNull(block : (Array<T>) -> Unit, vararg elements : T?) {
    val validElements = arrayListOf<T>()
    for (i in elements) {
       if (i == null) return
       validElements.add(i)
    }
    block.invoke(validElements.toArray(elements))
}