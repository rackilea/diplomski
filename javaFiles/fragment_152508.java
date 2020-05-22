inline fun <reified T> f(a: Any) {
}

fun <T> g(a: Any) {
    f<T>(a) // error
}