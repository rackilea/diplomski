inline fun <T> doIfNotNull(elements: Array<T?>, block : (Array<T>) -> Unit) {
    val validElements = arrayListOf<T>()
    for (i in elements) {
       if (i == null) return
       validElements.add(i)
    }
    block.invoke(validElements.toArray(elements))
}