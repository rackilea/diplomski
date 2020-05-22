fun test() {
    val elements = arrayOf(1L, 2L, null)
    doIfNotNull(elements, {
        it.sum()
    })
}