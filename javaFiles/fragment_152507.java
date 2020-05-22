inline fun <reified T> f(a: Any) {
    g<T>(a)
}

inline fun <reified T> g(a: Any) {
    if (a is T) println("Bingo!")
}