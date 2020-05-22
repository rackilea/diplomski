fun <T, V> CoroutineScope.debounce(
    waitMs: Long = 300L,
    destinationFunction: T.(V) -> Unit
): T.(V) -> Unit {
    var debounceJob: Job? = null
    return { param: V ->
        debounceJob?.cancel()
        debounceJob = launch {
            delay(waitMs)
            destinationFunction(param)
        }
    }
}