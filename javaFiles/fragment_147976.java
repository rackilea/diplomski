class Ex() {
    fun m() {
        var p2 = Ex::class.java.simpleName
        println("p2:${p2}")
    }
}

fun main(args: Array<String>) {
    Ex().m()
}