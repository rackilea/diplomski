fun insideRepeat() {
    repeat(1024) {
        doSomething(('a'..'z').random())
    }
}

fun outsideRepeat() {
    val range = 'a'..'z'
    repeat(1024) {
        doSomething(range.random())
    }
}