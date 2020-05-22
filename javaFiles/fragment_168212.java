inline fun catchThrowable(block: () -> Unit): Throwable? = try {
    block()
    null
} catch (e: Throwable) {
    e
}