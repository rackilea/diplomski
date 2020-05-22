private val executor = Executors.newCachedThreadPool() // equivalent to io()

fun <T> waitAll(tasks: List<Callable<T>>): List<T> {
    return executor.invokeAll(tasks).map {
        it.get()
    }
}