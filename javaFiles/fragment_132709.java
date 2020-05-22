private interface MarkedIOThread // Marker interface

private val IO_EXECUTOR = Executors.newSingleThreadExecutor { r -> 
    return object : Thread(r), MarkedIOThread 
}

fun notInIOThread(): Boolean = Thread.currentThread() !is MarkedIOThread