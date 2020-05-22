inline fun <T> catch(crossinline block: () -> T): () -> T {
    return { block(); };
}

inline fun <T> (() -> T).by(exceptionally: (Throwable) -> T): T {
    return only { exceptionally(it) }!!
}

inline fun <T : R, R> (() -> T).only(exceptionally: (Throwable) -> R): R? {
    try {
        return invoke();
    } catch(e: UndeclaredThrowableException) {
        return exceptionally(e.cause ?: e);
    } catch(e: Exception) {
        return exceptionally(e);
    }
}